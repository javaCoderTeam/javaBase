package com.chen.api.util.thread.study.chapter3.waitReleaseLock;

/**
 * @author chen weijie
 * @date 2018-05-07 11:58 PM
 */
public class ThreadA extends Thread {


    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }


}