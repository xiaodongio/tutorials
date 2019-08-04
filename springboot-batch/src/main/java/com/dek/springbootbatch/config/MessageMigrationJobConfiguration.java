package com.dek.springbootbatch.config;

import com.dek.springbootbatch.domain.Message;
import com.dek.springbootbatch.listener.MessageItemReadListener;
import com.dek.springbootbatch.listener.MessageWriteListener;
import com.dek.springbootbatch.listener.StringJobCompletionListener;
import com.dek.springbootbatch.mapper.MessageLineMapper;
import com.dek.springbootbatch.processor.StringProcessor;
import com.dek.springbootbatch.reader.StringReader;
import com.dek.springbootbatch.writer.StringWriter;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import javax.annotation.processing.Processor;
import java.io.File;



public class MessageMigrationJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

//    @Bean
//    public Job messageMigrationJob(@Qualifier("messageMigrationStep") Step messageMigrationStep) {
//        return jobBuilderFactory.get("messageMigrationJob")
//                .start(messageMigrationStep)
//                .build();
//    }
//
//
//
//    @Bean
//    public Step messageMigrationStep(@Qualifier("jsonMessageReader") FlatFileItemReader<Message> jsonMessageReader,
//                                     @Qualifier("messageItemWriter") JpaItemWriter<Message> messageItemWriter,
//                                     @Qualifier("errorWriter") Writer errorWriter) {
//        return stepBuilderFactory.get("messageMigrationStep")
//                .<Message, Message>chunk(500)
//                .reader(jsonMessageReader).faultTolerant().skip(JsonParseException.class).skipLimit(100)
//                .listener(new MessageItemReadListener(errorWriter))
//                .writer(messageItemWriter).faultTolerant().skip(Exception.class).skipLimit(100)
//                .listener(new MessageWriteListener())
//                .build();
//    }
//
//
//    /**
//     * Reader顾名思义就是从数据源读取数据。
//     * Spring Batch给我们提供了很多好用实用的reader。比如FlatFileItemReader，JdbcCursorItemReader，JpaPagingItemReader等。
//     * 也可以自己实现Reader
//     * @return
//     */
//    @Bean
//    public FlatFileItemReader<Message> jsonMessageReader() {
//        FlatFileItemReader<Message> reader = new FlatFileItemReader<>();
//        reader.setResource(new FileSystemResource(new File(MESSAGE_FILE)));
//        reader.setLineMapper(new MessageLineMapper());
//        return reader;
//    }






}
