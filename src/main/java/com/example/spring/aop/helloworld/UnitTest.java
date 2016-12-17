package com.example.spring.aop.helloworld;

import org.junit.Test;

/**
 * Created by Forrest on 2016/12/17.
 */
public class UnitTest {
    @Test
    public  void test(){
//        //直接写sout的日志方式，很多缺点
//        ArithmeticCaculator caculator=new ArithmeticCaculatorLoggingImp();
//
//        caculator.add(1,2);
//        caculator.mul(2,4);

        //代理输出日志方式
        ArithmeticCaculator caculatorProxy=new ArithmeticCaculatorLoggingProxy(
                new ArithmeticCaculatorImp()).getLoggingProxy();
        caculatorProxy.add(2,3);
        caculatorProxy.mul(4,5);


    }
}

