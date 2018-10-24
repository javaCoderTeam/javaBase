package com.chen.api.util.thread.volatiledemo;

/**
 * synchronized 锁保证原子性
 *
 * @author :  chen weijie
 * @Date: 2018-10-24 9:07 PM
 */
public class VolatileDemo1 {


    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileDemo1 test = new VolatileDemo1();
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
