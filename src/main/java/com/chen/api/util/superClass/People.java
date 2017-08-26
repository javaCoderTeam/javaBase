package com.chen.api.util.superClass;

/**
 * Created by Chen Weijie on 2017/7/19.
 */
public class People {

    private String name;

    private int age;

    People(String name, int age) {
        this.age = age;
        this.name = name;
    }
    People(){

    }


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
}
