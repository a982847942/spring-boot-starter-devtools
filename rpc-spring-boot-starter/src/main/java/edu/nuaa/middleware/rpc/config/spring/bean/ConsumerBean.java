package edu.nuaa.middleware.rpc.config.spring.bean;

import com.alibaba.fastjson.JSON;
import edu.nuaa.middleware.rpc.config.ConsumerConfig;
import edu.nuaa.middleware.rpc.domain.RpcProviderConfig;
import edu.nuaa.middleware.rpc.network.client.ClientSocket;
import edu.nuaa.middleware.rpc.network.msg.Request;
import edu.nuaa.middleware.rpc.reflect.JDKProxy;
import edu.nuaa.middleware.rpc.registry.RedisRegistryCenter;
import edu.nuaa.middleware.rpc.util.ClassLoaderUtils;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 17:26
 */
public class ConsumerBean<T> extends ConsumerConfig implements FactoryBean {
    private ChannelFuture channelFuture;

    private RpcProviderConfig rpcProviderConfig;

    @Override
    public Object getObject() throws Exception {

        //从redis获取链接
        if (null == rpcProviderConfig) {
            String infoStr = RedisRegistryCenter.obtainProvider(nozzle, alias);
            rpcProviderConfig = JSON.parseObject(infoStr, RpcProviderConfig.class);
        }
        assert null != rpcProviderConfig;

        //获取通信channel
        if (null == channelFuture) {
            ClientSocket clientSocket = new ClientSocket(rpcProviderConfig.getHost(), rpcProviderConfig.getPort());
            new Thread(clientSocket).start();
            for (int i = 0; i < 100; i++) {
                if (null != channelFuture) break;
                Thread.sleep(500);
                channelFuture = clientSocket.getFuture();
            }
        }

        Request request = new Request();
        request.setChannel(channelFuture.channel());
        request.setNozzle(nozzle);//接口
        request.setRef(rpcProviderConfig.getRef());//接口的实现类
        request.setAlias(alias);//别名
        return (T) JDKProxy.getProxy(ClassLoaderUtils.forName(nozzle), request);
    }

    @Override
    public Class<?> getObjectType() {
        try {
            return ClassLoaderUtils.forName(nozzle);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
