package com.chen.api.util.thread.study.chapter2.synchronizedOneThreadIn;

/**
 * @author chen weijie
 * @date 2018-04-14 9:56 PM
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
        service.serviceMethod();
    }


}
