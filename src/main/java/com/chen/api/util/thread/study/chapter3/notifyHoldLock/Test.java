package com.chen.api.util.thread.study.chapter3.notifyHoldLock;

/**
 * @author chen weijie
 * @date 2018-05-08 12:20 AM
 */
public class Test {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();

        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();

        SynNotifyMethodThread notifyMethodThread = new SynNotifyMethodThread(lock);
        notifyMethodThread.start();
    }

}
