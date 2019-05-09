package com.dek.producer;


import com.dek.pojo.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void topic(Order order, String routingKey){
        rabbitTemplate.convertAndSend("mytopic", routingKey, order);
    }

}
