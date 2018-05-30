package com.chen.api.util.thread.study.chapter7.threadRunSyn;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 01:08
 */
public class Run {

    public static void main(String[] args) {

        Object lock = new Object();

        MyThread a = new MyThread(lock, "a", 1);
        MyThread b = new MyThread(lock, "b", 2);
        MyThread c = new MyThread(lock, "c", 3);
        a.start();
        b.start();
        c.start();
    }


}
