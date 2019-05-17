package com.dek.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * ChannelInboundHandler 接口 提供可以覆盖的各种事件处理程序方法
 * 而ChannelInboundHandlerAdapter 声明了 ChannelInboundHandler 接口，所以只需要自己扩展前者，而不用实现接口
 *
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // Discard the received data silently.
//        ((ByteBuf)msg).release();

        ByteBuf buf = (ByteBuf) msg;
        try {
            if (buf.isReadable()) {
                System.out.println(buf.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //在大多数情况下，应该记录捕获的异常并在此处关闭其关联的通道
        ctx.close();
    }
}
