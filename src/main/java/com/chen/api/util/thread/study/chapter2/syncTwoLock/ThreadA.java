package com.chen.api.util.thread.study.chapter2.syncTwoLock;

import com.chen.api.util.thread.study.chapter2.throwExceptionNoLock.ThreadB;

/**
 * @author chen weijie
 * @date 2018-04-16 2:52 AM
 */
public class ThreadA extends Thread {


    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printA();
    }

}
