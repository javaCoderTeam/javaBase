package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum2;

/**
 * @author chen weijie
 * @date 2018-04-12 1:29 AM
 */
public class ThreadA3 extends Thread {

    private SynHasPrivateNum numRef;

    public ThreadA3(SynHasPrivateNum numRef) {
        this.numRef = numRef;
    }

    public void run() {
        super.run();
        numRef.addI("a");

    }
}
