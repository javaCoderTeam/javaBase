package com.chen.api.util.thread.study.chapter3.waitInterruptException;

/**
 * @author chen weijie
 * @date 2018-05-08 12:28 AM
 */
public class Service {


    public void testMethod(Object lock) {

        try {
            synchronized (lock) {
                System.out.println("begin wait");
                lock.wait();
                System.out.println("end wait");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
