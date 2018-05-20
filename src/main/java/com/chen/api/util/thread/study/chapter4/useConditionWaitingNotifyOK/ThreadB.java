package com.chen.api.util.thread.study.chapter4.useConditionWaitingNotifyOK;

/**
 * @author :  chen weijie
 * @Date: 2018-05-19 00:18
 */
public class ThreadB extends Thread {


    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        myService.awaitB();
    }


}
