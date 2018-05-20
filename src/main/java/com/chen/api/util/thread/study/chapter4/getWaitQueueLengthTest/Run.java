package com.chen.api.util.thread.study.chapter4.getWaitQueueLengthTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-20 23:57
 */
public class Run {

    public static void main(String[] args) {

        Service service = new Service();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };


        Thread[] threadArray = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }


        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.notifyMethod();


    }


}
