package com.example.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tang on 2016/12/12.
 */
public class UnitTest {
    @Test
    public  void test(){
        // i will review spring these days!
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld= (HelloWorld) context.getBean("hello");
        helloWorld.hello();

    }
}
