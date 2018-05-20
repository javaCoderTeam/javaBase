package com.chen.api.util.thread.study.chapter4.fair_noFair_test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-20 23:03
 */
public class Service {


    private ReentrantLock lock;

    public Service(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {

        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "获得锁权限");
        } finally {
            lock.unlock();
        }


    }


}
