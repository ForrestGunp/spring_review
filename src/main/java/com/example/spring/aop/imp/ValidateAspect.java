package com.example.spring.aop.imp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *  验证切面,利用@Order标签可以设置切面的优先级,值越小，优先级越高
 */
@Order(1)
@Aspect
@Component
public class ValidateAspect {

    @Before("com.example.spring.aop.imp.LoggingAspect.declareJoinPoint()")
    public void  beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println("Validate method "+methodName+" args "+ Arrays.asList(args));
    }
}
