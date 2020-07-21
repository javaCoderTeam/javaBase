package com.chen.api.util.thread.study.chapter4.readWriteLockBegin3;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 01:51
 */
public class Service {


    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public void read() {

        try {
            lock.readLock().lock();
            System.out.println("thread:" + Thread.currentThread().getName() + "获得读锁，time==" + System.currentTimeMillis());
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }


    }

    public void write() {

        try {
            lock.writeLock().lock();
            System.out.println("thread:" + Thread.currentThread().getName() + "获得写锁，time==" + System.currentTimeMillis());
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }


    }


}
