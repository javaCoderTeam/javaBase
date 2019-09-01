package com.chen.api.util.thread.study.chapter7.stateTest4;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:19
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        synchronized (LockDemo.lock) {
            try {
                LockDemo.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
