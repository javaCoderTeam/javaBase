package com.chen.api.util.thread.study.chapter4.testHasWaiters;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 00:23
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
            System.out.println("有没有线程正在等待condition？" + lock.hasWaiters(condition) + " 线程数是多少？" + lock.getWaitQueueLength(condition));
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


}
