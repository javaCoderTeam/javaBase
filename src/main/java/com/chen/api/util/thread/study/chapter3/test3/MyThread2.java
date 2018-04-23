package com.chen.api.util.thread.study.chapter3.test3;

/**
 * @author :  chen weijie
 * @Date: 2018-04-24 00:16
 */
public class MyThread2 extends Thread {


    private Object lock;

    public MyThread2(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("开始  notify time:" + System.currentTimeMillis());
                lock.notify();
                System.out.println("结束  notify time:" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

}
