package com.dek.protobuf;

import com.dek.proto.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtobufClientHandler extends SimpleChannelInboundHandler<Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Student student) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush(Student.newBuilder().setId(1L).setName("dek").setAddress("cn").build());
    }
}
