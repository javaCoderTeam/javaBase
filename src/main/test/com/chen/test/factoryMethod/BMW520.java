package com.chen.test.factoryMethod;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:03
 */
public class BMW520 implements BMW {

    private String name;

    public BMW520(String name) {
        this.name = name;
    }

    @Override
    public void buildBMW() {
        System.out.println("build BMW :" + name);
    }
}
