package com.chen.api.util.thread.study.chapter2.twoObjectTwoLock;

import com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum.HasPrivateNum;

/**
 * @author chen weijie
 * @date 2018-04-12 12:58 AM
 */
public class ThreadA extends Thread {


    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
