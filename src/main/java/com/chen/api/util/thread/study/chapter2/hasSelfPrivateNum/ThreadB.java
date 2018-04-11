package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum;

import com.chen.api.util.thread.study.chapter2.twoObjectTwoLock.HasSelfPrivateNum;

/**
 * @author chen weijie
 * @date 2018-04-12 1:06 AM
 */
public class ThreadB extends Thread {

    private HasPrivateNum numRef;

    public ThreadB(HasPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
