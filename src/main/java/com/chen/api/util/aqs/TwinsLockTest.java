package com.chen.api.util.aqs;

import java.util.concurrent.locks.Lock;

/**
 * @author :  chen weijie
 * @Date: 2019-08-17 09:58
 */
public class TwinsLockTest {


    public static void main(String[] args) {

        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {

                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }


        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setName("test"+i);
            w.start();
        }


        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
