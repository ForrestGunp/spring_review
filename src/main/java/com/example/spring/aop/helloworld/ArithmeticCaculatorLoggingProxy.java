package com.example.spring.aop.helloworld;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Forrest on 2016/12/17.
 */
public class ArithmeticCaculatorLoggingProxy {

    //要代理的对象
    private ArithmeticCaculator target;

    public ArithmeticCaculatorLoggingProxy(ArithmeticCaculator target) {
        this.target = target;
    }

    public ArithmeticCaculator getLoggingProxy(){
        ArithmeticCaculator proxy=null;

        //由哪一个类加载器加载
        ClassLoader classLoader=target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces=new Class[]{ArithmeticCaculator.class};
        //当调用代理对象其中的方法时，执行该代码
        InvocationHandler invocationHandler=new InvocationHandler() {
            /**
             *
             * @param proxy 正在返回的那个代理对象，一般情况下，都不使用该对象
             * @param method 正在被调用的方法
             * @param args 调用方法时传入的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //日志
                System.out.println("The method"+method.getName()+" is start with "+ Arrays.asList(args));
                //执行方法
                Object object=method.invoke(target,args);
                //日志
                System.out.println("The method "+method.getName()+"is ends with:"+object);
                return object;
            }
        };


        proxy= (ArithmeticCaculator) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
        return proxy;
    }
}
