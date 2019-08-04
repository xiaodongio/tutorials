package com.dek.springbootbatch.processor;

import org.springframework.batch.item.ItemProcessor;

public class StringProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String s) throws Exception {
        return s.toUpperCase();
    }
}
