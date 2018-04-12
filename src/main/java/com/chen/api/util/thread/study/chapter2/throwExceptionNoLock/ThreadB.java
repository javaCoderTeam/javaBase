package com.chen.api.util.thread.study.chapter2.throwExceptionNoLock;

/**
 * @author chen weijie
 * @date 2018-04-13 12:58 AM
 */
public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod();
    }
}
