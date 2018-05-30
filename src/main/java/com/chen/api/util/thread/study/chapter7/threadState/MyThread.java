package com.chen.api.util.thread.study.chapter7.threadState;

/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:52
 */
public class MyThread extends Thread {


    public MyThread() {
        System.out.println("构造方法中的状态。。" + Thread.currentThread().getState());
    }

    @Override
    public void run() {
        System.out.println("run方法中的状态。。" + Thread.currentThread().getState());
    }

}
