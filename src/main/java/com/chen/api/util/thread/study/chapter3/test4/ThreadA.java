package com.chen.api.util.thread.study.chapter3.test4;

/**
 * @author :  chen weijie
 * @Date: 2020-07-11 18:34
 */
public class ThreadA extends Thread {


    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);

    }

}
