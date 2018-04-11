package com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject2;

import com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject.MyObject;

/**
 * @author chen weijie
 * @date 2018-04-12 2:12 AM
 */
public class ThreadA extends Thread {

    private MyObjectOT myObject;

    public ThreadA(MyObjectOT myObject) {
        super();
//        Thread.currentThread().setName("aAAAAAAAAAAAAAAAAA");
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodA();

    }

}
