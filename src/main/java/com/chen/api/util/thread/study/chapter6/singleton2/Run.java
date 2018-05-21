package com.chen.api.util.thread.study.chapter6.singleton2;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 23:41
 */
public class Run {

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread1.start();
        myThread2.start();
        myThread3.start();

    }


}
