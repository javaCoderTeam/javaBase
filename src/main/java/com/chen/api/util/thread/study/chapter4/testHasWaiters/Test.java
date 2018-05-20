package com.chen.api.util.thread.study.chapter4.testHasWaiters;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 00:27
 */
public class Test {

    public static void main(String[] args) throws Exception {

        final Service service =new Service();

        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };


        Thread[] threads =new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i]=new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        Thread.sleep(2000);
        service.notifyMethod();
    }

}
