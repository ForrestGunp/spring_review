package com.example.spring.autowire;


/**
 * Created by Tang on 2016/12/13.
 */
public class Dao2 {
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(){
        System.out.println(dataSource.getProperties().get("type"));
    }
}
