package com.dek.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.dek.rabbitmq.Constants.IP_ADDRESS;
import static com.dek.rabbitmq.Constants.PORT;
import static com.dek.rabbitmq.Constants.QUEUE_NAME;

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[] {
          new Address(IP_ADDRESS, PORT)
        };

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("123");
        try (
            Connection connection = factory.newConnection(addresses); //创建连接
            final Channel channel = connection.createChannel()){ // 创建信道

            channel.basicQos(64); // 设置客户端最多接收未被 ack 的消息的个数

            com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println( " recv message: " + new String(body));


                    channel.basicAck(envelope.getDeliveryTag(), false);

                    throw new IOException();

//                    try {
//                        TimeUnit.SECONDS .sleep(1) ;
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        channel.basicAck(envelope.getDeliveryTag(), false);
//                    }
                }
            };

            channel.basicConsume(QUEUE_NAME, consumer);
            //等待回调函数执行完毕之后
            TimeUnit.SECONDS.sleep(5);
        }

    }


}
