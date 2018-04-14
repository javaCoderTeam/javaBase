package com.chen.api.util.thread.study.chapter2.synBlockingString;

/**
 * @author chen weijie
 * @date 2018-04-15 2:31 AM
 */
public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.setUserNamePassword("a", "aa");
    }

}
