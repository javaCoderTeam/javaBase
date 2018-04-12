package com.chen.api.util.thread.study.chapter2.synLockIn;

/**
 * @author chen weijie
 * @date 2018-04-13 12:43 AM
 */
public class Service {


    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }
}
