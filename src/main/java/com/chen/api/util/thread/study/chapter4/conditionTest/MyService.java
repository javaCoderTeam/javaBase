package com.chen.api.util.thread.study.chapter4.conditionTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-19 01:59
 */
public class MyService {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean hashValue = false;

    public void set() {
        try {
            lock.lock();
            while (hashValue) {
                condition.await();
            }
            System.out.println("打印AAAA");
            hashValue = true;
            condition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void get() {
        try {
            lock.lock();
            while (!hashValue) {
                condition.await();
            }
            System.out.println("打印BBBB");
            hashValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
