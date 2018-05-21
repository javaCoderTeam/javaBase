package com.chen.api.util.thread.study.chapter6.singleton3;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 23:41
 */
public class Run {

    public static void main(String[] args) {

        MyThread myThread11 = new MyThread();
        MyThread myThread22 = new MyThread();
        MyThread myThread33 = new MyThread();

        myThread11.start();
        myThread22.start();
        myThread33.start();

    }


}
