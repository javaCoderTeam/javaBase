package com.chen.api.util.thread.study.chapter4.reentrantLockTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-16 23:52
 */
public class MyThread extends Thread {


    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        myService.testMethod();
    }


}
