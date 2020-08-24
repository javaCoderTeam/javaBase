package com.chen.algorithm.fooBarThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2020-08-04 16:57
 */
public class ReentrantLockFooBar {
    public ReentrantLockFooBar() {
    }

    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock(true);
    volatile boolean permitFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            if (permitFoo) {
                printFoo.run();
                i++;
                permitFoo = false;
            }
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            if (!permitFoo) {
                printBar.run();
                i++;
                permitFoo = true;
            }
            lock.unlock();
        }
    }
}

