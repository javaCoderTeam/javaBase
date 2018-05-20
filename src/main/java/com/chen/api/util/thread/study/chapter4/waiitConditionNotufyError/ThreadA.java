package com.chen.api.util.thread.study.chapter4.waiitConditionNotufyError;

/**
 * @author :  chen weijie
 * @Date: 2018-05-17 00:50
 */
public class ThreadA extends Thread {


    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;

    }

    @Override
    public void run() {
        service.await();
    }


}
