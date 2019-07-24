package com.dek.service;


import org.springframework.stereotype.Service;

@Service
public class OtherService {

    public String test() {
        try {
            throw new Exception("otherService.test");
        } catch (Exception e) {
            throw new RuntimeException("otherService.test.catch");
        }
    }

}
