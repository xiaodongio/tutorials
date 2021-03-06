package com.dek.springbootbatch.listener;

import com.dek.springbootbatch.domain.Message;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Writer;
import java.util.List;

import static java.lang.String.format;

public class MessageWriteListener implements ItemWriteListener<Message> {

    @Autowired
    private Writer errorWriter;

    @Override
    public void beforeWrite(List<? extends Message> list) {

    }

    @Override
    public void afterWrite(List<? extends Message> list) {

    }

    @Override
    public void onWriteError(Exception e, List<? extends Message> list) {
//        errorWriter.write(format("%s%n", e.getMessage()));
//        for (Message message : list) {
//            errorWriter.write(format("Failed writing message id: %s", message.getObjectId()));
//        }
    }
}
