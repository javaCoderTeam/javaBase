package com.chen.api.util.thread.study.chapter4.readWriteLockBegin1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 01:36
 */
public class Service {


    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {

        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
