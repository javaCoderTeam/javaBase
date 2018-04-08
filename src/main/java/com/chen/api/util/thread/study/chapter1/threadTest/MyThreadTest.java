package com.chen.api.util.thread.study.chapter1.threadTest;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-08 1:21 AM
 */
public class MyThreadTest {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("运行结束!");
    }
}
