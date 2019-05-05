package com.dek.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.dek.rabbitmq.Constants.QUEUE_NAME;

public class NewTask {


    public static void main(String[] args) throws IOException, TimeoutException {
        try (Connection connection = ConnectionUtil.newConnection();
             Channel channel = connection.createChannel()){
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            String message = String.join(" ", "d", "e", "k");

            channel.basicPublish("", QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes("UTF-8"));
            System.out.println("Sent '" + message + "'");

        }
    }


}
