package com.example.spring.aop.by_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class ValidateAspect {

    public void  beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println("Validate method "+methodName+" args "+ Arrays.asList(args));
    }
}
