package com.example.spring.wire_detail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tang on 2016/12/12.
 */
public class UnitTest {
    @Test
    public  void  test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person= (Person) context.getBean("person");
        System.out.println(person);

        Person person2= (Person) context.getBean("person2");
        System.out.println(person2);


        person= (Person) context.getBean("person3");
        System.out.println(person);

//        person= (Person) context.getBean("person4");
//        System.out.println(person);

       Person2 person4= (Person2) context.getBean("person4");
        System.out.println(person4);
    }
}
