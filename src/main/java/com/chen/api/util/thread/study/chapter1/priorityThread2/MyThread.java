package com.chen.api.util.thread.study.chapter1.priorityThread2;

import java.util.Random;

/**
 * cpu会优先执行优先级比较高的线程对象中的任务.所以优先级高的线程会比优先级低的线程获取更多的cpu时间
 *
 * @author chen weijie
 * @date 2018-04-11 1:23 AM
 */
public class MyThread extends Thread {

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
            System.out.println("time====================A===" + (endTime - beginTime));
        }

    }
}
