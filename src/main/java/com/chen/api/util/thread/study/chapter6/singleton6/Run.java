package com.chen.api.util.thread.study.chapter6.singleton6;

/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:16
 */
public class Run {


    public static void main(String[] args) {

        MyThread myThread8 = new MyThread();
        MyThread myThread9 = new MyThread();
        MyThread myThread0 = new MyThread();

        myThread0.start();
        myThread8.start();
        myThread9.start();

    }

}
