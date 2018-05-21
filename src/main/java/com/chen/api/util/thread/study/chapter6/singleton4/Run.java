package com.chen.api.util.thread.study.chapter6.singleton4;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 23:57
 */
public class Run {

    public static void main(String[] args) {

        MyThread myThread4 = new MyThread();
        MyThread myThread5 = new MyThread();
        MyThread myThread6 = new MyThread();


        myThread4.start();
        myThread5.start();
        myThread6.start();


    }

}
