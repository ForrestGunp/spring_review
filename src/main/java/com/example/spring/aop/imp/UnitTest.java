package com.example.spring.aop.imp;

import com.example.spring.aop.helloworld.ArithmeticCaculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Forrest on 2016/12/17.
 */
public class UnitTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationAop.xml");

        ArithmeticCaculator caculator= (ArithmeticCaculator) context.getBean("arithmeticCaculator");
        int result=caculator.add(1,2);
        System.out.println("The result is:"+result);

        result=caculator.div(12,2);
        System.out.println("The result is:"+result);
    }
}
