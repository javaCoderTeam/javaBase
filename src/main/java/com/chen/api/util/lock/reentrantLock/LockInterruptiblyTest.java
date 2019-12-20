package com.chen.api.util.lock.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 构造死锁场景:创建两个子线程,子线程在运行时会分别尝试获取两把锁。其中一个线程先获取锁1在获取锁2，另一个线程正好相反。如果没有外界中断，该程序将处于死锁状态永远无法停止。
 *
 * @author :  chen weijie
 * @Date: 2019-11-11 18:41
 */
public class LockInterruptiblyTest {


    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        Thread thread = new Thread(new ThreadDemo(lock1, lock2));
        Thread thread1 = new Thread(new ThreadDemo(lock2, lock1));

        thread.start();
        thread1.start();
        thread.interrupt();
    }


    static class ThreadDemo implements Runnable {

        Lock firstLock;
        Lock secondLock;

        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            try {
                firstLock.lockInterruptibly();
                TimeUnit.MILLISECONDS.sleep(10);
                secondLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束");
            }
        }
    }


}
