package com.chen.api.util.thread.study.chapter2.test2;

/**
 * @author chen weijie
 * @date 2018-04-16 1:41 AM
 */
public class ThreadB extends Thread {

    private MyObject object;

    private Service service;

    public ThreadB(MyObject object, Service service) {
        super();
        this.object = object;
        this.service = service;
    }

    @Override
    public void run(){
        super.run();
        object.speedPrintString();
    }


}
