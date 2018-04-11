package com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject;

/**
 * @author chen weijie
 * @date 2018-04-12 2:12 AM
 */
public class ThreadB extends Thread {

    private MyObject myObject;

    public ThreadB(MyObject myObject) {
        super();
//        Thread.currentThread().setName("bBBBBBBBBBBBBBBBBBB");
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodA();

    }

}
