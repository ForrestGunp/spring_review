package com.example.spring.wire_detail;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Person2有多辆车，List集合装车
 */
public class Person2 {
    private String name;
    private int  age;
    private List<Car> cars;
    private Map<String,Object> params;
    private Set<Object> attrs;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Set<Object> getAttrs() {
        return attrs;
    }

    public void setAttrs(Set<Object> attrs) {
        this.attrs = attrs;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                ", params=" + params +
                ", attrs=" + attrs +
                '}';
    }
}
