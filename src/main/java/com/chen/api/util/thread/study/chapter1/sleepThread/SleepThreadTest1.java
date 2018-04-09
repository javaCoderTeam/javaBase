package com.chen.api.util.thread.study.chapter1.sleepThread;

/**
 * @author Chen WeiJie
 * @date 2018-04-09 20:57
 **/
public class SleepThreadTest1 {

    public static void main(String[] args) {

        SleepThreadTest sleepThreadTest =new SleepThreadTest();
        sleepThreadTest.run();
        System.out.println(Thread.currentThread().getName()+"的id是："+Thread.currentThread().getId());

    }
}
