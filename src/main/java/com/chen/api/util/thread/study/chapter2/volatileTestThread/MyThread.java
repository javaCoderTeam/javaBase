package com.chen.api.util.thread.study.chapter2.volatileTestThread;

/**
 * @author chen weijie
 * @date 2018-04-22 10:58 PM
 */
public class MyThread extends Thread {

    volatile public static int count;

    private static void addCount() {

        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count==" + count);
    }

    @Override
    public void run() {
        addCount();
    }


}
