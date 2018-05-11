package com.chen.api.util.thread.study.chapter3.waitInterruptException;

/**
 * @author chen weijie
 * @date 2018-05-08 12:29 AM
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Object object = new Object();
        ThreadA threadA = new ThreadA(object);
        threadA.start();
        threadA.setName("a");
        Thread.sleep(1000);
        threadA.interrupt();
    }

}
