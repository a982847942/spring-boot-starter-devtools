package edu.nuaa.middleware.rpc.config.spring.bean;

import com.alibaba.fastjson.JSON;
import edu.nuaa.middleware.rpc.config.ProviderConfig;
import edu.nuaa.middleware.rpc.domain.LocalServerInfo;
import edu.nuaa.middleware.rpc.domain.RpcProviderConfig;
import edu.nuaa.middleware.rpc.registry.RedisRegistryCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 17:27
 */
public class ProviderBean extends ProviderConfig implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(ProviderBean.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        RpcProviderConfig rpcProviderConfig = new RpcProviderConfig();
        rpcProviderConfig.setNozzle(nozzle);
        rpcProviderConfig.setRef(ref);
        rpcProviderConfig.setAlias(alias);
        rpcProviderConfig.setHost(LocalServerInfo.LOCAL_HOST);
        rpcProviderConfig.setPort(LocalServerInfo.LOCAL_PORT);

        //注册生产者
        long count = RedisRegistryCenter.registryProvider(nozzle, alias, JSON.toJSONString(rpcProviderConfig));

        logger.info("注册生产者：{} {} {}", nozzle, alias, count);
    }

}
