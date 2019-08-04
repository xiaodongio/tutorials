package com.dek.springbootbatch.config;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 如果要实现多Job的情况，需要把EnableBatchProcessing注解的modular设置为true，让每个Job使用自己的ApplicationConext。
 */
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing(modular = true)
public class SpringBatchConfiguration {

//    @Bean
//    public ApplicationContextFactory messageMigrationJobContext() {
//        return new GenericApplicationContextFactory(MessageMigrationJobConfiguration.class);
//    }

//    @Bean
//    public ApplicationContextFactory stringJobContext() {
//        return new GenericApplicationContextFactory(StringJobConfiguration.class);
//    }

//    @Bean
//    public ApplicationContextFactory helloJobContext() {
//        return new GenericApplicationContextFactory(HelloWorldConfiguration.class);
//    }


    @Bean
    public ApplicationContextFactory jobFlowContext() {
        return new GenericApplicationContextFactory(JobFlowConfiguration.class);
    }

}
