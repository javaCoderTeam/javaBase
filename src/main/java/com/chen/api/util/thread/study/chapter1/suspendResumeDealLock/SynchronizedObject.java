package com.chen.api.util.thread.study.chapter1.suspendResumeDealLock;

/**
 * 同步对象 suspend和Resume方法独占(独占锁) 同步的对象
 *
 * @author chen weijie
 * @date 2018-04-11 12:14 AM
 */
public class SynchronizedObject {

    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程挂了");
            Thread.currentThread().suspend();
        }
    }
}
