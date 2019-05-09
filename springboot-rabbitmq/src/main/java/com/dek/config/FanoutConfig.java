package com.dek.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {


    @Bean
    public Queue orderNotifyQueue() {
        return new Queue("order.notify");
    }

    @Bean
    public Queue orderPaymentQueue() {
        return new Queue("order.payment");
    }

    @Bean
    public FanoutExchange orderExchange() {
        return new FanoutExchange("orderExchange");
    }

    @Bean
    public Binding orderPaymentBinding() {
        return BindingBuilder.bind(orderPaymentQueue()).to(orderExchange());
    }

    @Bean
    public Binding orderNotifyBinding() {
        return BindingBuilder.bind(orderNotifyQueue()).to(orderExchange());
    }


}
