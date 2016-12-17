package com.example.spring.aop.helloworld;

/**
 * Created by Forrest on 2016/12/17.
 */
public class ArithmeticCaculatorLoggingImp implements ArithmeticCaculator {
    public int add(int i, int j) {
        System.out.println("The method is start with add and params are ["+i+","+j+"]");
        int result=i+j;
        System.out.println("The method add result is "+result);
        return result;
    }

    public int sub(int i, int j) {
        System.out.println("The method is start with sub and params are ["+i+","+j+"]");
        int result=i-j;
        System.out.println("The method sub result is "+result);
        return result;
    }

    public int mul(int i, int j) {
        System.out.println("The method is start with mul and params are ["+i+","+j+"]");
        int result=i*j;
        System.out.println("The method mul result is "+result);
        return result;
    }

    public int div(int i, int j) {
        System.out.println("The method is start with div and params are ["+i+","+j+"]");
        int result=i/j;
        System.out.println("The method div result is "+result);
        return result;
    }
}
