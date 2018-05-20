package com.chen.api.util.thread.study.chapter4.reentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-16 23:48
 */
public class MyService {


    private Lock lock = new ReentrantLock();


    public void testMethod() {

        //lock（）方法加锁
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + (i + 1));
        }
        //unlock()方法释放锁
        lock.unlock();
    }


}
