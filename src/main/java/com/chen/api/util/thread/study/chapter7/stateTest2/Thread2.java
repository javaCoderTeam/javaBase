package com.chen.api.util.thread.study.chapter7.stateTest2;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:11
 */
public class Thread2 extends Thread {



    @Override
    public void run(){

        MyService.serviceMethod();
    }
}
