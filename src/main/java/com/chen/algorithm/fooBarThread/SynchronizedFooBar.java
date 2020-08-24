package com.chen.algorithm.fooBarThread;

/**
 * @author :  chen weijie
 * @Date: 2020-08-04 17:39
 */
public class SynchronizedFooBar {

    private int n;
    private boolean fooTurn = true;
    private Object lock = new Object();

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock) {
                if (!fooTurn) {
                    lock.wait();
                }
                fooTurn = false;
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock) {
                if (fooTurn) {
                    lock.wait();
                }
                fooTurn = true;
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock.notifyAll();
            }
        }
    }

}
