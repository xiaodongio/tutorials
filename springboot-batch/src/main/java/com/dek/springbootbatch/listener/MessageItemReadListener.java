package com.dek.springbootbatch.listener;

import com.dek.springbootbatch.domain.Message;
import org.springframework.batch.core.ItemReadListener;

import java.io.Writer;

import static java.lang.String.format;

public class MessageItemReadListener implements ItemReadListener<Message> {

    private Writer errorWriter;

    public MessageItemReadListener(Writer errorWriter) {
        this.errorWriter = errorWriter;
    }

    @Override
    public void beforeRead() {

    }

    @Override
    public void afterRead(Message message) {

    }

    @Override
    public void onReadError(Exception e) {

        errorWriter.write(format("%s%n", e.getMessage()));
    }

}
