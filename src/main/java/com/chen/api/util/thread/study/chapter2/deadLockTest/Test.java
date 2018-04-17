package com.chen.api.util.thread.study.chapter2.deadLockTest;

/**
 * @author chen weijie
 * @date 2018-04-18 12:18 AM
 */
public class Test {

    public static void main(String[] args) {

        DealThreadTask task = new DealThreadTask();
        task.setFlag("a");
        Thread thread1 = new Thread(task);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(task);
        task.setFlag("b");
        thread2.start();


    }

}
