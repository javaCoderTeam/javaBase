package com.chen.api.util.reflection.ClassMethod;

/**
 * @author Chen WeiJie
 * @date 2017-12-22 12:28
 **/
public class SuperC {


    private String name;

    public SuperC() {

    }

    public SuperC(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
