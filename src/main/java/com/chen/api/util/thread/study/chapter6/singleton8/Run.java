package com.chen.api.util.thread.study.chapter6.singleton8;

/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:29
 */
public class Run {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.start();
        myThread1.start();
        myThread2.start();


    }

}
