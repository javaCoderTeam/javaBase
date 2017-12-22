package com.chen.api.util.reflection;

/**
 * 汽车类
 *
 * @author chen weijie
 * @date 2017-12-08 12:09 AM
 */
public class Car {

    private String brand;

    private String color;

    private Integer maxSpeed;


    public Car() {
    }

    public Car(String brand, String color, Integer maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String introduce() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
