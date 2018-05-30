package com.chen.api.util.thread.study.chapter7.threadGroup;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:35
 */
public class ThreadB extends Thread {


    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                System.out.println("threadName:" + Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
