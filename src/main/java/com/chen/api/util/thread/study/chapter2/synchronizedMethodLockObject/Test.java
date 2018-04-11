package com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject;

/**
 * @author chen weijie
 * @date 2018-04-12 2:14 AM
 */
public class Test {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        ThreadB threadB = new ThreadB(myObject);
        threadA.setName("a");
        threadB.setName("b'");
        threadA.start();
        threadB.start();
    }

}
