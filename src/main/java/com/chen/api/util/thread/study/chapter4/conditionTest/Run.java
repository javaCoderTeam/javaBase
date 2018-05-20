package com.chen.api.util.thread.study.chapter4.conditionTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-19 02:08
 */
public class Run {

    public static void main(String[] args) {

        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();

        ThreadB threadB = new ThreadB(myService);
        threadB.start();
    }


}
