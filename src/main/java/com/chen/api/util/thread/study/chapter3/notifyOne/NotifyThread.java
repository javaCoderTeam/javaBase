package com.chen.api.util.thread.study.chapter3.notifyOne;

/**
 * @author chen weijie
 * @date 2018-05-08 12:41 AM
 */
public class NotifyThread extends Thread {


    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }


    @Override
    public void run() {

        synchronized (lock) {
//            lock.notify();
            lock.notifyAll();
        }

    }
}
