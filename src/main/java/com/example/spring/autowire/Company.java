package com.example.spring.autowire;

/**
 * Created by Tang on 2016/12/13.
 */
public class Company {
    private String name;
    private int scale;
    private String city;
    private String street;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", scale=" + scale +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
