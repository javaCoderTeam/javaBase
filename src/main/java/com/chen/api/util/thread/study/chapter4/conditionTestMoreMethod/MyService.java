package com.chen.api.util.thread.study.chapter4.conditionTestMoreMethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-17 00:11
 */
public class MyService {


    private Lock lock = new ReentrantLock();


    public void methodA() {

        try {
            lock.lock();
            System.out.println("methodA begin ThreadName= " + Thread.currentThread().getName() + ",time =" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA end ThreadName= " + Thread.currentThread().getName() + ",time =" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void methodB() {

        try {
            lock.lock();
            System.out.println("methodB begin ThreadName= " + Thread.currentThread().getName() + ",time =" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end ThreadName= " + Thread.currentThread().getName() + ",time =" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


}
