package com.chen.api.util.thread.study.chapter2.doubleSynBlockOneTwo;

/**
 * @author chen weijie
 * @date 2018-04-15 1:40 AM
 */
public class ThreadA extends Thread {


    private ObjectService service;

    public ThreadA(ObjectService service) {
        super();
        this.service = service;

    }


    @Override
    public void run() {
        super.run();
        service.serviceMethodA();
    }


}
