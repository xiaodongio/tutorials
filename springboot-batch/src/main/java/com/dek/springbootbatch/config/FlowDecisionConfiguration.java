package com.dek.springbootbatch.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowDecisionConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("firstStep").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("firstStep");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step oddStep() {
        return stepBuilderFactory.get("oddStep").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("oddStep");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step evenStep() {
        return stepBuilderFactory.get("evenStep").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("evenStep");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }


    @Bean
    public JobExecutionDecider myDecider() {
        return new JobExecutionDecider() {

            private int count = 0;

            @Override
            public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {

                count++;
                if (count%2 == 0) {
                    return new FlowExecutionStatus("EVEN");
                } else {
                    return new FlowExecutionStatus("ODD");
                }

            }
        };
    }

    @Bean
    public Job flowDecisionJob() {
        return jobBuilderFactory.get("flowDecisionJob")
                .start(firstStep())
                .next(myDecider())
                .from(myDecider()).on("EVEN").to(evenStep())
                .from(myDecider()).on("ODD").to(oddStep())
                .from(oddStep()).on("*").to(myDecider())
                .end()
                .build();
    }


}
