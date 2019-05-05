package com.dek.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.dek.rabbitmq.Constants.*;

public class Producer {

    /**
     * 生产者客户端的代码首先和 RabbitMQ 服务器建立 个连接 Connection 然后在
     这个连接之上创建 个信道 （Channel) 。之后创建一个交换器 Exchange 和一个队列 Queue)
     并通过路由键进行绑定。然后发送一条消息 最后关闭资源。
     * @param args
     * @throws IOException
     * @throws TimeoutException
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("root");
        factory.setPassword("123");
        try (
            Connection connection = factory.newConnection(); //创建连接
            Channel channel = connection.createChannel()) { // 创建信道

            // 创建一个 type="direct" 、持久化的、非自动删除的交换器
            channel.exchangeDeclare(EXCHANGE_NAME, "direct" , true , false , null) ;
            //创建一个持久化、非排他的、非自动删除的队列
            channel. queueDeclare(QUEUE_NAME , true , false , false , null) ;
            //将交换器与队列通过路由键绑定
            channel.queueBind(QUEUE_NAME , EXCHANGE_NAME , ROUTING_KEY);
            //发送一条持久化的消息: hello world !
            String message = "Hello World !";
            channel.basicPublish(EXCHANGE_NAME , ROUTING_KEY ,
                    MessageProperties.PERSISTENT_TEXT_PLAIN ,
                    message.getBytes()) ;


        }
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
