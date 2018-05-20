package com.chen.api.util.thread.study.chapter4.useConditionWaitingNotifyOK;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-19 00:08
 */
public class MyService {

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();

    private Condition conditionB = lock.newCondition();


    public void awaitA() {

        try {
            lock.lock();
            System.out.println("begin awaitA时间为：" + System.currentTimeMillis() + ",ThreadName =" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为：" + System.currentTimeMillis() + ",ThreadName =" + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {

        try {
            lock.lock();
            System.out.println("begin awaitB时间为：" + System.currentTimeMillis() + ",ThreadName =" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB时间为：" + System.currentTimeMillis() + ",ThreadName =" + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {

        try {
            lock.lock();
            System.out.println("signalAll_A 时间为：" + System.currentTimeMillis() + ",ThreadName =" + Thread.currentThread().getName());
            conditionA.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void signalAll_B() {

        try {
            lock.lock();
            System.out.println("signalAll_B 时间为：" + System.currentTimeMillis() + ",ThreadName =" + Thread.currentThread().getName());
            conditionB.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


}
