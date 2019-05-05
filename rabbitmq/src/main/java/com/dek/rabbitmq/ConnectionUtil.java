package com.dek.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.dek.rabbitmq.Constants.IP_ADDRESS;
import static com.dek.rabbitmq.Constants.PORT;

public class ConnectionUtil {

    public static Connection newConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("root");
        factory.setPassword("123");
        return factory.newConnection();
    }

}
