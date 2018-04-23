package com.chen.api.util.thread.study.chapter3.test3;

/**
 * @author :  chen weijie
 * @Date: 2018-04-24 00:24
 */
public class Test {

    public static void main(String[] args) {

        Object lock = new Object();
        MyThread1 thread1 = new MyThread1(lock);
        thread1.setName("a");
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyThread2 thread2 = new MyThread2(lock);
        thread2.setName("b");
        thread2.start();

    }
}
