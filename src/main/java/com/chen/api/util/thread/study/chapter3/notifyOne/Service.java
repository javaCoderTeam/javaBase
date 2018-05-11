package com.chen.api.util.thread.study.chapter3.notifyOne;

/**
 * @author chen weijie
 * @date 2018-05-08 12:40 AM
 */
public class Service {

    public void testMethod(Object lock) {

        try {
            synchronized (lock) {
                System.out.println("begin wait,threadName" + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait,threadName" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
