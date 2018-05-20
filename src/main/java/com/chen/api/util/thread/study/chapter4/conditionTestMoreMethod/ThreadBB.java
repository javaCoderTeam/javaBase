package com.chen.api.util.thread.study.chapter4.conditionTestMoreMethod;

/**
 * @author :  chen weijie
 * @Date: 2018-05-17 00:14
 */
public class ThreadBB extends Thread {

    private MyService service;

    public ThreadBB(MyService service) {
        this.service = service;
    }


    @Override
    public void run() {
        service.methodB();
    }


}
