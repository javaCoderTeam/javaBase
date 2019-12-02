package com.chen.api.util.lock.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 等待超时
 *
 * @author :  chen weijie
 * @Date: 2019-11-11 18:49
 */
public class TryLockTest {


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
                while (!firstLock.tryLock()) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println("firstLock 未获取到");
                }

                while (!secondLock.tryLock()) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println("secondLock 未获取到");
//                    lock1.unlock();
                }

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
