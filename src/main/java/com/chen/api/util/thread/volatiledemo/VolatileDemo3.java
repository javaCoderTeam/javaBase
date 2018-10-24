package com.chen.api.util.thread.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 锁保证原子性
 * @author :  chen weijie
 * @Date: 2018-10-24 9:07 PM
 */
public class VolatileDemo3 {

    public AtomicInteger  inc = new AtomicInteger(0);

    public void increase() {
        inc.incrementAndGet();
    }

    public static void main(String[] args) {
        final VolatileDemo3 test = new VolatileDemo3();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }

            }).start();
        }
        //保证前面的线程都执行完
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(test.inc);
    }
}
