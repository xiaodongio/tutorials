package com.dek.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.dek.rabbitmq.Constants.QUEUE_NAME;

public class Worker {


    public static void main(String[] args) throws IOException, TimeoutException {
        try (Connection connection = ConnectionUtil.newConnection();
             Channel channel = connection.createChannel()){
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            channel.basicQos(1);

            DeliverCallback deliverCallback = ((consumerTag, message) -> {
                String content = new String(message.getBody(), "UTF-8");
                System.out.println("Received '" + message + "'");
                try {
                    doWork(content);
                } finally {
                    System.out.println("Done");
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                }
            });
            channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
        }
    }

    private static void doWork(String content) {
        for (char ch : content.toCharArray()) {
            if (ch == 'd') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
