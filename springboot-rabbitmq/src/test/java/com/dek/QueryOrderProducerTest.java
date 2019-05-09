package com.dek;


import com.dek.pojo.Order;
import com.dek.producer.QueryOrderProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryOrderProducerTest {

    @Autowired
    private QueryOrderProducer queryOrderProducer;


    @Test
    public void testProducer() {
        queryOrderProducer.produce(new Order(UUID.randomUUID().toString()), "direct");
    }

}
