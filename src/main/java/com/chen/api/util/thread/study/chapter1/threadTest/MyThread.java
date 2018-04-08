package com.chen.api.util.thread.study.chapter1.threadTest;

/**
 * 继承thread类的多线程
 *
 * @author chen weijie
 * @date 2018-04-08 1:20 AM
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        Thread.currentThread().setName("MyThread线程..");
        System.out.println(Thread.currentThread().getName() + "正在运行..");
    }

}
