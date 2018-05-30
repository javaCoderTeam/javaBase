package com.chen.api.util.thread.study.chapter7.stateTest2;


/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:03
 */
public class Run {

    public static void main(String[] args) {

        Thread1 thread1 = new Thread1();
        thread1.setName("1");
        thread1.start();

        Thread2 thread2 = new Thread2();
        thread2.setName("2");
        thread2.start();

        System.out.println("thread2的状态：" + thread2.getState());


    }


}
