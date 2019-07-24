package com.dek;

import com.dek.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {


    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("db.xml");
        UserService userService = context.getBean(UserService.class);
        userService.add1();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        userService.add2();
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);

//        for (int i=0;i<10;i++) {
            userService.testData();
//        }
    }


    @Test
    public void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        try {
            userService.save("123", 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
