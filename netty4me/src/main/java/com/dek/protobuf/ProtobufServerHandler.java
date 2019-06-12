package com.dek.protobuf;

import com.dek.proto.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtobufServerHandler extends SimpleChannelInboundHandler<Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Student student) throws Exception {
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAddress());
    }
}
