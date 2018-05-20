package com.chen.api.util.thread.study.chapter4.conditionTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-19 02:06
 */
public class ThreadB extends Thread {


    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            service.get();
        }

    }


}
