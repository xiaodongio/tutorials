package com.dek.producer;

import com.dek.pojo.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void order(Order order) {
        // 只要与orderExchange 绑定的队列   就会收到消息   与 Routingkey无关
        amqpTemplate.convertAndSend("orderExchange", "ignore", order);
        amqpTemplate.convertAndSend("orderExchange", "order.notify", order);
        amqpTemplate.convertAndSend("orderExchange", "order.payment", order);
        amqpTemplate.convertAndSend("orderExchange", "order", order);
        amqpTemplate.convertAndSend("orderExchange", "", order);
    }


}
