package com.chen.api.util.thread.study.chapter2.twoStop;


/**
 * @author chen weijie
 * @date 2018-04-17 11:58 PM
 */
public class ThreadB extends Thread {


    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.methodA();
    }


}
