package com.dek.springbootbatch.mapper;

import com.dek.springbootbatch.domain.Message;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import org.springframework.batch.item.file.LineMapper;

public class MessageLineMapper implements LineMapper<Message> {


    private MappingJsonFactory factory = new MappingJsonFactory();

    @Override
    public Message mapLine(String s, int i) throws Exception {
        return null;
    }
}
