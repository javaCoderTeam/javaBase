package com.chen.api.util.thread.study.chapter2.syncTwoLock;

/**
 * @author chen weijie
 * @date 2018-04-16 2:52 AM
 */
public class ThreadC extends Thread {


    private Service service;

    public ThreadC(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printC();
    }

}
