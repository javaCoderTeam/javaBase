package com.chen.api.util.thread.study.chapter3.notifyHoldLock;

/**
 * @author chen weijie
 * @date 2018-05-08 12:10 AM
 */
public class Service {


    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait(),threadName==" + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait(),threadName==" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void synNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin notify()==" + Thread.currentThread().getName() + ",time==" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("end notify()==" + Thread.currentThread().getName() + ",time==" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
