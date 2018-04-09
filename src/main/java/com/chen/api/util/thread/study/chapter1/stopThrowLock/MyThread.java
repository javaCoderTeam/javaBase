package com.chen.api.util.thread.study.chapter1.stopThrowLock;

/**
 * stop释放锁
 *
 * @author chen weijie
 * @date 2018-04-10 1:13 AM
 */
public class MyThread extends Thread {

    private SynchronizedObject object;

    public MyThread(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }

}
