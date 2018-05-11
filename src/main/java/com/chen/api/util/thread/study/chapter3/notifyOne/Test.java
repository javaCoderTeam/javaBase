package com.chen.api.util.thread.study.chapter3.notifyOne;

/**
 * @author chen weijie
 * @date 2018-05-08 12:43 AM
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();
        ThreadA a = new ThreadA(o);
        a.start();

        ThreadB b = new ThreadB(o);
        b.start();

        ThreadC c = new ThreadC(o);
        c.start();
        Thread.sleep(5000);

        NotifyThread notifyThread = new NotifyThread(o);
        notifyThread.start();
    }

}
