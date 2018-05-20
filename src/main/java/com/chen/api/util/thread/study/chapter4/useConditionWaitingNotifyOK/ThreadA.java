package com.chen.api.util.thread.study.chapter4.useConditionWaitingNotifyOK;

/**
 * @author :  chen weijie
 * @Date: 2018-05-19 00:18
 */
public class ThreadA extends Thread {


    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        myService.awaitA();
    }


}
