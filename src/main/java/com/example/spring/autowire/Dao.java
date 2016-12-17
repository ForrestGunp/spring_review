package com.example.spring.autowire;

import com.example.spring.wire_detail.DataSource;

/**
 * Created by Tang on 2016/12/13.
 */
public class Dao {
    private String dataSource="dbcp";

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public void save(){
        System.out.println("save by:"+dataSource);
    }

}
