package com.dek.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ReceiveLogs {

    public static void main(String[] args) throws IOException, TimeoutException {
        try (Connection connection = ConnectionUtil.newConnection();
             Channel channel = connection.createChannel()){
            channel.exchangeDeclare(Constants.EXCHANGE_LOG, "fanout");
            String queueName = channel.queueDeclare().getQueue();

            channel.queueBind(queueName, Constants.EXCHANGE_LOG, "");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("Received '" + message + "'");
            };


            channel.basicConsume(queueName, false, deliverCallback, consumerTag -> { });
        }
    }

}
