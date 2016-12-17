package com.example.spring.aop.by_xml;

import com.example.spring.aop.helloworld.ArithmeticCaculator;
import org.springframework.stereotype.Component;

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
