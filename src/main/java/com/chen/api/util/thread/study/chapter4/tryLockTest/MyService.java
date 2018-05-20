package com.chen.api.util.thread.study.chapter4.tryLockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 00:46
 */
public class MyService {


    public ReentrantLock lock = new ReentrantLock();

    public void waitMethod() {

        if (lock.tryLock()) {
            System.out.println("threadName:" + Thread.currentThread().getName() + "获得锁");
        } else {
            System.out.println("threadName:" + Thread.currentThread().getName() + "未获得获得锁");
        }
    }


}
