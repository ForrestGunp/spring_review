package com.example.spring.beans;

/**
 * Created by Tang on 2016/12/12.
 */
public class Car {
    private String brand;
    private String color;
    private double price;
    private int maxSpeed;

    /**
     * 当有其他构造方法时必须写一个空的构造方法来让IOC容器创建这个bean
     */
    public Car() {

    }
    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
    public Car(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
