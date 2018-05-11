package com.chen.api.util.thread.study.chapter3.notifyHoldLock;

import java.io.Serializable;

/**
 * @author chen weijie
 * @date 2018-05-08 12:15 AM
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
