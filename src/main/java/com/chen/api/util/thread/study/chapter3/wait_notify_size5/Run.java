package com.chen.api.util.thread.study.chapter3.wait_notify_size5;

/**
 * @author :  chen weijie
 * @Date: 2018-04-24 00:49
 */
public class Run {


    public static void main(String[] args) {

        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.setName("a");
        threadA.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadB threadB = new ThreadB(lock);
        threadB.setName("b");
        threadB.start();


    }
}
