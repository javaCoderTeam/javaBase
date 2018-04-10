package com.chen.api.util.thread.study.chapter1.priorityThread2;

import java.util.Random;

/**
 * @author chen weijie
 * @date 2018-04-11 1:23 AM
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {

        long beginTime = System.currentTimeMillis();
        long result = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                result = result + i;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("time====================B==" + (endTime - beginTime));
        }

    }
}
