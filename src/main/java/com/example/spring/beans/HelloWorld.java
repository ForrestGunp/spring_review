package com.example.spring.beans;

/**
 * Created by Tang on 2016/12/12.
 */
public class HelloWorld {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void  hello(){
        System.out.println("hello:"+name);
    }
}
