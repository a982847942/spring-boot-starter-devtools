package edu.nuaa.middleware.rpc.network.client;

import edu.nuaa.middleware.rpc.network.future.SyncWriteFuture;
import edu.nuaa.middleware.rpc.network.future.SyncWriteMap;
import edu.nuaa.middleware.rpc.network.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:53
 */
public class MyClientHandler  extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
        Response msg = (Response) obj;
        String requestId = msg.getRequestId();
        SyncWriteFuture future = (SyncWriteFuture) SyncWriteMap.syncKey.get(requestId);
        if (future != null) {
            future.setResponse(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


}
