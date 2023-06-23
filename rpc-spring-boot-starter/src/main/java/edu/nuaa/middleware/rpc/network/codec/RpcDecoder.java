package edu.nuaa.middleware.rpc.network.codec;

import edu.nuaa.middleware.rpc.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:54
 */
public class RpcDecoder extends ByteToMessageDecoder {
    private Class<?> genericClass;

    public RpcDecoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4){
            return;
        }
        in.markReaderIndex();//记录读指针
        int dataLength = in.readInt();//读取数据的长度
        if (in.readableBytes() < dataLength) {
            //可读数据小于数据长度 重置读指针
            in.resetReaderIndex();
            return;
        }
        //读取数据
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        //反序列化
        out.add(SerializationUtil.deserialize(data, genericClass));
    }
}
