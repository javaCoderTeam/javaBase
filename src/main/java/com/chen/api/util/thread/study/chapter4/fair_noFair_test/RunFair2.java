package com.chen.api.util.thread.study.chapter4.fair_noFair_test;

/**
 * @author :  chen weijie
 * @Date: 2018-05-20 23:13
 */
public class RunFair2 {

    public static void main(String[] args) {

        //不公平锁
        final Service service = new Service(false);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("--------" + Thread.currentThread().getName());
                service.serviceMethod();
            }
        };

        Thread[] threadArray = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
            threadArray[i].start();
        }


    }

}
