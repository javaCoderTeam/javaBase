package com.chen.api.util.thread.study.chapter4.readWriteLockBegin2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 01:36
 */
public class Service {


    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {

        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(1000);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
