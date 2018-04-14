package com.chen.api.util.thread.study.chapter2.doubleSynBlockOneTwo;

/**
 * @author chen weijie
 * @date 2018-04-15 1:40 AM
 */
public class ThreadB extends Thread {


    private ObjectService service;

    public ThreadB(ObjectService service) {
        super();
        this.service = service;

    }


    @Override
    public void run() {
        super.run();
        service.serviceMethodB();
    }


}
