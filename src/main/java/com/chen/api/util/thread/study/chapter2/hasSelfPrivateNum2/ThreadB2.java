package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum2;

import com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum.HasPrivateNum;

/**
 * @author chen weijie
 * @date 2018-04-12 1:06 AM
 */
public class ThreadB2 extends Thread {

    private HasPrivateNum2 numRef2;

    public ThreadB2(HasPrivateNum2 numRef2) {
        super();
        this.numRef2 = numRef2;
    }

    @Override
    public void run() {
        super.run();
        numRef2.addI("b");
    }
}
