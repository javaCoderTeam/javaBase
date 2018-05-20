package com.chen.api.util.thread.study.chapter4.getWaitQueueLengthTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-20 23:53
 */
public class Service {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    public void waitMethod() {

        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void notifyMethod() {

        try {
            lock.lock();
            System.out.println("有" + lock.getWaitQueueLength(condition) + "个线程在等待condition");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }





}
