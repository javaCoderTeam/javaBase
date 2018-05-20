package com.chen.api.util.thread.study.chapter4.conditionTestMoreMethod;

/**
 * @author :  chen weijie
 * @Date: 2018-05-17 00:14
 */
public class ThreadB extends Thread {

    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }


    @Override
    public void run() {
        service.methodB();
    }


}
