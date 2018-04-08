package com.chen.api.util.thread.study.chapter1.runnableTest;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-08 1:38 AM
 */
public class MyRunnableTest {

    public static void main(String[] args) {

        Runnable myRunnable = new MyRunnable();

        Thread t = new Thread(myRunnable, "指定threadName的线程");

        t.start();
        System.out.println("main 线程在运行..");
    }
}
