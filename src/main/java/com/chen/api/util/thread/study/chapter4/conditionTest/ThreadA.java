package com.chen.api.util.thread.study.chapter4.conditionTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-19 02:06
 */
public class ThreadA extends Thread {



    private MyService service;

    public ThreadA (MyService service){

        this.service =service;

    }


    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            service.set();
        }

    }






}
