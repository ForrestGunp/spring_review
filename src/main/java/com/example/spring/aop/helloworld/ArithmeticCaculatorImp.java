package com.example.spring.aop.helloworld;

/**
 * Created by Forrest on 2016/12/17.
 */
public class ArithmeticCaculatorImp implements ArithmeticCaculator {
    public int add(int i, int j) {
        int result=i+j;
        return result;
    }

    public int sub(int i, int j) {
        int result=i-j;
        return result;
    }

    public int mul(int i, int j) {
        int result=i*j;
        return result;
    }

    public int div(int i, int j) {
        int result=i/j;
        return result;
    }
}
