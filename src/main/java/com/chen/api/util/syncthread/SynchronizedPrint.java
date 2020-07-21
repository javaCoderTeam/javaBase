package com.chen.api.util.syncthread;

/**
 * @author :  chen weijie
 * @Date: 2020-07-01 13:18
 */
public class SynchronizedPrint implements Runnable {

    private static final Object lock = new Object();
    private static int count = 0;


    @Override
    public void run() {

        while (true) {
            synchronized (lock) {
                if (count % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                lock.notifyAll();
            }
        }
    }
}
