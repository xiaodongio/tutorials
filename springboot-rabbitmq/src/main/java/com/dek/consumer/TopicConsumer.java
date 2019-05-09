package com.dek.consumer;


import com.dek.pojo.Order;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {


    @RabbitListener(queues = "topicqueue1")
    @RabbitHandler
    public void topic1(Order order) {
        System.out.println("topicqueue1 收到消息");
        System.out.println(order);
    }

    @RabbitListener(queues = "topicqueue2")
    @RabbitHandler
    public void topic2(Order order) {
        System.out.println("topicqueue2 收到消息");
        System.out.println(order);
    }

}
