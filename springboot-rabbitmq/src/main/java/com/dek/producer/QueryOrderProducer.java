package com.dek.producer;

import com.dek.pojo.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryOrderProducer {
    @Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void produce(Order order, String routingKey){
		rabbitTemplate.convertAndSend("direct", routingKey, order);
	}
}