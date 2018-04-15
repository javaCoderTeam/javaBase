package com.chen.api.util.thread.study.chapter2.synBlockingString2;

/**
 * @author chen weijie
 * @date 2018-04-15 2:31 AM
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
        service.b();
    }

}
