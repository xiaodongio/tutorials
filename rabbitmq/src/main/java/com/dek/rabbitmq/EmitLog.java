package com.dek.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EmitLog {

    public static void main(String[] args) throws IOException, TimeoutException {
        try (Connection connection = ConnectionUtil.newConnection();
             Channel channel = connection.createChannel()){
            channel.exchangeDeclare(Constants.EXCHANGE_LOG, "fanout");

            String message = "info: hello world!";

            channel.basicPublish(Constants.EXCHANGE_LOG, "", null, message.getBytes());
            System.out.println("Sent " + message);
        }
    }

}
