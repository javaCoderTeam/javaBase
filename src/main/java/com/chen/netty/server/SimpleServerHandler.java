package com.chen.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 服务端处理类
 *
 * @author :  chen weijie
 * @Date: 2019-10-18 20:15
 */
public class SimpleServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 本方法用于读取客户端发送的信息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("simpleServerHandler.channelRead ");
        ByteBuf result = (ByteBuf) msg;
        byte[] results1 = new byte[result.readableBytes()];
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
        result.readBytes(results1);

        String resultStr = new String(results1);
        System.out.println("client said:" + resultStr);
        // 释放资源，这行很关键
        result.release();

        //向客户端发送信息
        String response = "hello client";
        // 在当前场景下，发送的数据必须转换成byteBuf数组
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }


    /**
     * 本方法用作处理异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 信息获取完毕后操作
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }


}
