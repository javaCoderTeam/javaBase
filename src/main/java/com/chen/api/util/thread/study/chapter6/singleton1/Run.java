package com.chen.api.util.thread.study.chapter6.singleton1;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 23:37
 */
public class Run {


    public static void main(String[] args) {


        MyThread myThreadA = new MyThread();
        MyThread myThreadB = new MyThread();
        MyThread myThreadC = new MyThread();
        myThreadA.start();
        myThreadB.start();
        myThreadC.start();


    }

}
