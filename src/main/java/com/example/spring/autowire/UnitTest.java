package com.example.spring.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tang on 2016/12/13.
 */
public class UnitTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springAutowire.xml");

        Action action = (Action) context.getBean("action");
        action.excute();

        DataSource dataSource= (DataSource) context.getBean("dataSource2");
        System.out.println(dataSource.getProperties().get("url"));

        Dao2 dao2= (Dao2) context.getBean("dao3");
        dao2.save();

        Company company= (Company) context.getBean("company2");
        System.out.println(company);

    }

}
