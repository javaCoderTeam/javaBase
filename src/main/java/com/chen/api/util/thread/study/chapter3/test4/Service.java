package com.chen.api.util.thread.study.chapter3.test4;

/**
 * @author :  chen weijie
 * @Date: 2020-07-11 18:36
 */
public class Service {

    public void testMethod(Object lock) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+",begin....");
            try {
//                Thread.sleep(1);
                lock.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+",end....");

        }


    }


}
