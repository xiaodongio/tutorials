package com.dek.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

	@Bean
    public Queue queryOrderQueue() {
        return new Queue("query.order1");
    }

    @Bean
    public Queue queryUserQueue() {
        return new Queue("query.order2");
    }

    @Bean
    public DirectExchange directExchange() {
	    return new DirectExchange("direct");
    }

    @Bean
    public Binding changjiangBinding() {
	    return BindingBuilder.bind(queryOrderQueue()).to(directExchange()).with("changjiang");
    }

    @Bean
    public Binding yangtzeBinding() {
        return BindingBuilder.bind(queryUserQueue()).to(directExchange()).with("yangtze");
    }

    @Bean
    public Binding yellowRiverBinding() {
        return BindingBuilder.bind(queryUserQueue()).to(directExchange()).with("yellowRiver");
    }
}