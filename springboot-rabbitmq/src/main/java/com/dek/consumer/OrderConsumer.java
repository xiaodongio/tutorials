package com.dek.consumer;

import com.dek.pojo.Order;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitHandler
    @RabbitListener(queues = "order.notify")
    public void orderNotify(Order order) {
        System.out.println("order.notify 收到了消息");
        System.out.println(order);
    }

    @RabbitHandler
    @RabbitListener(queues = "order.payment")
    public void orderPayment(Order order) {
        System.out.println("order.payment 收到了消息");
        System.out.println(order);
    }

}
