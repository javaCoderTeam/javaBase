package com.chen.api.util.thread.study.chapter2.atomicIntegerTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chen weijie
 * @date 2018-04-22 11:29 PM
 */
public class AddCountThread extends Thread {

    private AtomicInteger count = new AtomicInteger();


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }
    }

}
