package edu.nuaa.middleware.rpc.network.server;

import edu.nuaa.middleware.rpc.domain.LocalServerInfo;
import edu.nuaa.middleware.rpc.network.codec.RpcDecoder;
import edu.nuaa.middleware.rpc.network.codec.RpcEncoder;
import edu.nuaa.middleware.rpc.network.msg.Request;
import edu.nuaa.middleware.rpc.network.msg.Response;
import edu.nuaa.middleware.rpc.util.NetUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.context.ApplicationContext;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:56
 */
public class ServerSocket implements Runnable{
    private ChannelFuture f;

    private transient ApplicationContext applicationContext;

    public ServerSocket(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
    public boolean isActiveSocketServer() {
        try {
            if (f != null) {
                return f.channel().isActive();
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public void run() {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(
                                    new RpcDecoder(Request.class),
                                    new RpcEncoder(Response.class),
                                    new MyServerHandler(applicationContext));
                        }
                    });

            //启动初始端口
            int port = 22201;
            /**
             * 防止端口22201被占用 启动失败，但是这种实现方式不好
             * 可以使用Future判断结果然后递增端口重连
             */
            while (NetUtil.isPortUsing(port)) {
                port++;
            }
            LocalServerInfo.LOCAL_HOST = NetUtil.getHost();
            LocalServerInfo.LOCAL_PORT = port;
            //注册服务
            this.f = b.bind(port).sync();
            this.f.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }
}
