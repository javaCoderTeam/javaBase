package com.chen.api.util.thread.volatiledemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 锁保证原子性
 * @author :  chen weijie
 * @Date: 2018-10-24 9:07 PM
 */
public class VolatileDemo2 {


    public volatile int inc = 0;

    Lock lock = new ReentrantLock();


    public void increase() {
        try {
            lock.lock();
            inc++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final VolatileDemo2 test = new VolatileDemo2();
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
