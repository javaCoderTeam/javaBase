package com.chen.api.util.reflection.ClassMethod;

/**
 * sub类
 *
 * @author Chen WeiJie
 * @date 2017-12-22 12:32
 **/
public class Sub extends SuperC implements SuperInterfaceA, SuperInterfaceB {

    private String name;

    public Sub() {
        super();
    }

    public Sub(String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
