package com.chen.test.adapter;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:18
 */
public class TestMain {


    public static void main(String[] args) {

        Target target = new Adapter(new Adaptee());
        target.request();
    }


}
