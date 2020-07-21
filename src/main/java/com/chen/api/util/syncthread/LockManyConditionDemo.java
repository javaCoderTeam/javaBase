package com.chen.api.util.syncthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2020-07-01 13:30
 */
public class LockManyConditionDemo {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        LockManyConditionDemo demo = new LockManyConditionDemo();

        new Thread(() -> demo.getAwait(demo.conditionA), "thread1_conditionA").start();
        new Thread(() -> demo.getAwait(demo.conditionB), "thread2_conditionB").start();
        new Thread(() -> demo.getSignal(demo.conditionA), "thread3_conditionA").start();
        System.out.println("稍等5秒再通知其他的线程！");
        Thread.sleep(5000);
        new Thread(() -> demo.getSignal(demo.conditionB), "thread4_conditionB").start();

    }

    private void getAwait(Condition condition) {
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

    private void getSignal(Condition condition) {
        lock.lock();
        System.out.println("发送通知signal！ ThreadName：" + Thread.currentThread().getName());
        condition.signal();
        lock.unlock();
    }


}
