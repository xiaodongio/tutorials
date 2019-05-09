package com.dek.controller;


import com.dek.pojo.Order;
import com.dek.producer.OrderProducer;
import com.dek.producer.QueryOrderProducer;
import com.dek.producer.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQController {

    @Autowired
    private QueryOrderProducer queryOrderProducer;
    @Autowired
    private OrderProducer orderProducer;
    @Autowired
    private TopicProducer topicProducer;


    @PostMapping("direct")
    public Order direct(Order order) {
        queryOrderProducer.produce(order, order.getRoutingKey());
        return order;
    }

    @PostMapping("fanout")
    public Order fanout(Order order) {
        orderProducer.order(order);
        return order;
    }

    @PostMapping("topic")
    public Order topic(Order order) {
        topicProducer.topic(order, order.getRoutingKey());
        return order;
    }

}
