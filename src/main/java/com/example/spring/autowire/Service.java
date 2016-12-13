package com.example.spring.autowire;

/**
 * Created by Tang on 2016/12/13.
 */
public class Service {
    private  Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public  void save(){
        System.out.println("Service's save!");
        dao.save();
    }
}
