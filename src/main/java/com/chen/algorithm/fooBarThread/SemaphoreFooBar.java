package com.chen.algorithm.fooBarThread;

import java.util.concurrent.Semaphore;

/**
 * @author :  chen weijie
 * @Date: 2020-08-04 17:15
 */
public class SemaphoreFooBar {


    public SemaphoreFooBar(){}
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++ ) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }

}
