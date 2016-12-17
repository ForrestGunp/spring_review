package com.example.spring.aop.imp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Forrest on 2016/12/17.
 */
@Order(2)
//首先将类交给IOC容器管理
@Component
//声明为切面
@Aspect
public class LoggingAspect {

    /**
     * 很多通知的切入点是一样的，我们就可以把切入点独立出来，
     * 这里只是单纯把切入点独立出来，方法体中不必谢任何代码
     *
     * 定义的切点表达式可以在其他切面重用
     */
    @Pointcut("execution(public int com.example.spring.aop.imp.ArithmeticCaculatorImp.*(int,int))")
    public void declareJoinPoint(){}

    /**
     * 前置通知
     * execution表达式:方法类型，方法返回类型，类路径，类名，方法名，方法参数类型，其中可以用通配符*代替
     *
     * JointPoint里面携带方法链接信息
     */
    @Before("declareJoinPoint()")
    public void beforeMethhod(JoinPoint point) {
        String methodName=point.getSignature().getName();
        List<Object> args= Arrays.asList(point.getArgs());
        //日志
        System.out.println("The method "+methodName+" start with:"+args);

    }

    /**
     * 后置通知，不论目标方法有没有抛出异常都将会执行，而且这里不能访问方法的执行结果
     *
     */
    @After("declareJoinPoint()")
    public void afterMethod(JoinPoint point){
        String methodName=point.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }

    /**
     * 返回通知
     * 在代理对象调用执行方法正常完后执行的代码，可以访问到方法的返回值
     */
    @AfterReturning(value = "declareJoinPoint()",
     returning = "object")
    public  void afterReturning(JoinPoint joinPoint,Object object){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends with "+object);

    }


    /**
     * 异常通知
     *在目标方法出现异常时执行的代码
     * 可以访问到异常对象；且可以指定在出现特定异常时再执行通知代码
     *
     * 下面表示的是所有的异常都将被触发这个通知
     */
    @AfterThrowing(value ="declareJoinPoint()",throwing = "ex")
    public  void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" occurs with "+ex);
    }

 /*   *//**
     * 只能触发空指针异常通知
     *//*
    @AfterThrowing(value ="execution(public int com.example.spring.aop.imp.ArithmeticCaculatorImp.*(int ,int ))",throwing = "ex")
    public  void afterThrowing(JoinPoint joinPoint,NullPointerException ex){

    }*/

    /**
     * 环绕通知
     * 环绕通知的过程和动态代理过程一样，object=proceedingPoint.proceed()就像代理对象中的Invocation类实例在invoke方法中执行
     * Object object=method.invoke(target,args)得到返回结果，并且object=proceedingPoint.proceed()、需要try catch异常
     * 然后我们就在可以在object=proceedingPoint.proceed();方法执行前模拟前置通知；
     *  在方法执行后模拟返回通知；
     *  在catch语句里面模拟异常通知；
     *  在整个模块完之后执行后置通知。
     *
     * @param proceedingPoint
     * @return
     */

   /* @Around("execution(public int com.example.spring.aop.imp.ArithmeticCaculatorImp.*(int ,int ))")
    public  Object aroundMethod(ProceedingJoinPoint proceedingPoint){
        Object object=null;
        String methodName=proceedingPoint.getSignature().getName();
        Object[] args=proceedingPoint.getArgs();

        try {
            //模拟前置通知
            System.out.println("The method "+methodName+" start with "+Arrays.asList(args));

             object=proceedingPoint.proceed();

            //模拟返回通知地方
            System.out.println("The method "+methodName+" ends with:"+object);
        } catch (Throwable throwable) {
            throwable.printStackTrace();

            //模拟异常通知
            System.out.println("The method occurs with "+throwable);
            //这个地方必须抛出Runtime异常，不然会try catch继续向下执行，返回null;
            throw  new RuntimeException(throwable);
        }

        //模拟后置通知
        System.out.println("The method "+methodName+" ends");

        return  object;
    }*/
}
