package com.chen.test.proxy;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 17:40
 */
public class RealSubject implements Subject {


    @Override
    public void request() {

        System.out.println("real subject request");
    }
}
