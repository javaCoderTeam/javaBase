package com.chen.api.util.thread.study.chapter3.test3;

/**
 * @author :  chen weijie
 * @Date: 2018-04-24 00:16
 */
public class MyThread1 extends Thread {


    private Object lock;

    public MyThread1(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            synchronized (lock) {
                System.out.println("开始  wait time:" + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束  wait time:" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
