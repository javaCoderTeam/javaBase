package com.chen.test.abstractFacory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:18
 */
public class BMW520Engine implements  Engine{

    @Override
    public void buildEngine() {
        System.out.println("build 520 engine");
    }
}
