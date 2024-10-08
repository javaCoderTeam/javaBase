package com.chen.api.util.syncthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2020-07-01 13:28
 */
public class LockConditionDemo {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        //使用同一个LockConditionDemo对象，使得lock、condition一样
        LockConditionDemo demo = new LockConditionDemo();
        new Thread(() -> demo.await(), "thread1").start();
        Thread.sleep(3000);
        new Thread(() -> demo.signal(), "thread2").start();
    }

    private void await() {
        try {
            lock.lock();
            System.out.println("开始等待await！ ThreadName：" + Thread.currentThread().getName());
            condition.await();
            System.out.println("等待await结束！ ThreadName：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signal() {
        lock.lock();
        System.out.println("发送通知signal！ ThreadName：" + Thread.currentThread().getName());
        condition.signal();
        lock.unlock();
    }
}
