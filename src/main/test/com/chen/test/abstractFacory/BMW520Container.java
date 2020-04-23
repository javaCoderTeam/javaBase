package com.chen.test.abstractFacory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:16
 */
public class BMW520Container implements Container {

    @Override
    public void buildContainer() {
        System.out.println("build 520 container");
    }
}
