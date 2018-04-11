package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum;


/**
 * @author chen weijie
 * @date 2018-04-12 12:58 AM
 */
public class ThreadA extends Thread {


    private HasPrivateNum numRef;

    public ThreadA(HasPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
