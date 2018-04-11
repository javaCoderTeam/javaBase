package com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject;

import com.chen.api.util.thread.threadPool.MyThread;

/**
 * @author chen weijie
 * @date 2018-04-12 2:12 AM
 */
public class ThreadA extends Thread {

    private MyObject myObject;

    public ThreadA(MyObject myObject) {
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
