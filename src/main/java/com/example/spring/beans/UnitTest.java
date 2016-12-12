package com.example.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tang on 2016/12/12.
 */
public class UnitTest {

    /**
     * spring helloworld
     */
    @Test
    public  void test(){
        // i will review spring these days!
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//        HelloWorld helloWorld= (HelloWorld) context.getBean("hello");
        HelloWorld helloWorld=context.getBean(HelloWorld.class);
        helloWorld.hello();


        Car car= (Car) context.getBean("car");
        System.out.println(car.toString());

        Car car1= (Car) context.getBean("car1");
        System.out.println(car1.toString());

    }


}
