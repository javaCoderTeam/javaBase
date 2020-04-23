package com.chen.test.abstractFacory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:17
 */
public class BMW320Engine implements Engine {


    @Override
    public void buildEngine() {
        System.out.println("build 320 engine");
    }
}
