package com.dek.springbootbatch.writer;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class StringWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String msg : list) {
            System.out.println("writing data " + msg);
        }
    }
}
