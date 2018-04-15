package com.chen.api.util.thread.study.chapter2.synBlockMoreObjectOneLock;


/**
 * @author chen weijie
 * @date 2018-04-16 2:52 AM
 */
public class ThreadB extends Thread {


    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printB();
    }

}
