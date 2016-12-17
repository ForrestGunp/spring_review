package com.example.spring.autowire;

/**
 * Created by Tang on 2016/12/13.
 */
public class Action {
    private Service service;

    public void setService(Service service) {
        this.service = service;
    }

    public  void  excute(){
        System.out.println("Action's excute!");
        service.save();
    }
}
