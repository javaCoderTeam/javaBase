package com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject2;

import com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject.MyObject;

/**
 * @author chen weijie
 * @date 2018-04-12 2:12 AM
 */
public class ThreadB extends Thread {

    private MyObjectOT myObject;

    public ThreadB(MyObjectOT myObject) {
        super();
//        Thread.currentThread().setName("bBBBBBBBBBBBBBBBBBB");
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodB();

    }

}
