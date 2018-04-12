package com.chen.api.util.thread.study.chapter2.synLockIn;

/**
 *
 * 关键字synchronized拥有锁重入的功能,当一个线程得到一个对象锁之后,再次请求此对象锁时,是可以再次获得该对象的锁的.
 * @author chen weijie
 * @date 2018-04-13 12:46 AM
 */
public class Test {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();
    }

}
