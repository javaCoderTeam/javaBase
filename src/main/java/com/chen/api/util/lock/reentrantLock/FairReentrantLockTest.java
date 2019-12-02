package com.chen.api.util.lock.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 * <p>
 * 大部分情况下我们使用非公平锁，因为其性能比公平锁好很多。但是公平锁能够避免线程饥饿，某些情况下也很有用。
 *
 * @author :  chen weijie
 * @Date: 2019-11-11 18:33
 */
public class FairReentrantLockTest {


    static Lock lock = new ReentrantLock(true);


    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadDemo(i)).start();
        }

    }


    static class ThreadDemo implements Runnable {

        Integer id;

        public ThreadDemo(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("获得锁的线程:" + id);
                lock.unlock();
            }


        }
    }


}
