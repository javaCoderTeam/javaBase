package com.chen.api.util.thread.study.chapter4.lockMethodTest2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 00:12
 */
public class Service {

    public ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void waitMethod() {

        try {
            lock.lock();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }







}
