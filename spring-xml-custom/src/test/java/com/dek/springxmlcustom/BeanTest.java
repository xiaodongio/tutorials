package com.dek.springxmlcustom;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");
        MyBean bean = context.getBean(MyBean.class);
        System.out.println("id : " + bean.getId());
        System.out.println("name : " + bean.getName());
    }

}
