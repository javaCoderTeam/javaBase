package com.chen.api.util.thread.study.chapter2.test2;

/**
 * @author chen weijie
 * @date 2018-04-16 1:39 AM
 */
public class Service {

    public void testMethod1(MyObject object) {

        synchronized (object) {
            try {
                System.out.println("testMethod1___________getLock,time===" + System.currentTimeMillis() + ",threadName:" + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("testMethod1___________releaseLock,time===" + System.currentTimeMillis() + ",threadName:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
