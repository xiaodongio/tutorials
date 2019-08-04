package com.dek.springbootbatch.config;

import com.dek.springbootbatch.listener.StringJobCompletionListener;
import com.dek.springbootbatch.processor.StringProcessor;
import com.dek.springbootbatch.reader.StringReader;
import com.dek.springbootbatch.writer.StringWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class StringJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job stringJob() {
        return jobBuilderFactory.get("stringJob")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .flow(orderStep1()).end().build();
    }

    @Bean
    public Step orderStep1() {
        return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)
                .reader(new StringReader()).processor(new StringProcessor())
                .writer(new StringWriter()).build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new StringJobCompletionListener();
    }

}
