package com.dek.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("mytopic");
    }

    @Bean
    public Queue topicQueue1() {
        Queue queue=new Queue("topicqueue1");
        return queue;
    }

    @Bean
    public Queue topicQueue2() {
        Queue queue=new Queue("topicqueue2");
        return queue;
    }

    //3个binding将交换机和相应队列连起来
    @Bean
    public Binding bindingtopic1(){
        Binding binding= BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("rabbit.topic.*");
        return binding;
    }

    @Bean
    public Binding bindingtopic2(){
        Binding binding=BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("rabbit.topic.#");
        return binding;
    }

    @Bean
    public Binding bindingtopic3(){
        Binding binding=BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("*.topic.*");
        return binding;
    }


}
