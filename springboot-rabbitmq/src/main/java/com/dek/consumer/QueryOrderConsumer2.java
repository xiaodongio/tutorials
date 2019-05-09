package com.dek.consumer;

import com.dek.pojo.Order;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "query.order2")
public class QueryOrderConsumer2 {
    @RabbitHandler
	public void consume(Order order) {
		System.out.println("query.order2 收到消息");
		System.out.println(order);
	}
}