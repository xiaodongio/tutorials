package com.dek.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.Instant;

public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        System.out.println("received " + textWebSocketFrame.text());
        channelHandlerContext.channel().writeAndFlush(new TextWebSocketFrame("current time " + Instant.now().toString()));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id().asLongText());
        System.out.println(ctx.channel().id().asShortText());
    }
}
