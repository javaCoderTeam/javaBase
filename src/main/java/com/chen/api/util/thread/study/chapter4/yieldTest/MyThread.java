package com.chen.api.util.thread.study.chapter4.yieldTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-31 01:27
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        long beginTIme = System.currentTimeMillis();
        int count = 0;

        for (int i = 0; i < 500000000; i++) {
            count = count + (i + 1);
            Thread.yield();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("用时：" + (endTime - beginTIme) + "ms");

    }


}
