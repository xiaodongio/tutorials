package com.dek.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;


public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static final ChannelGroup CHANNELS = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        CHANNELS.forEach(channel -> {
            if (channelHandlerContext.channel() != null) {
                channel.writeAndFlush(channelHandlerContext.channel() + " send msg " + msg + "\n");
            } else {
                channel.writeAndFlush("I send msg " + msg + "\n");
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
        CHANNELS.writeAndFlush("[server] - " + ctx.channel().remoteAddress() + "added \n");
        CHANNELS.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved");
        CHANNELS.writeAndFlush("[server] - " + ctx.channel().remoteAddress() + "removed \n");
//        CHANNELS.remove(ctx.channel());
        System.out.println(CHANNELS.size());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        CHANNELS.writeAndFlush("[server] - " + ctx.channel().remoteAddress() + " is online now \n");
    }
}
