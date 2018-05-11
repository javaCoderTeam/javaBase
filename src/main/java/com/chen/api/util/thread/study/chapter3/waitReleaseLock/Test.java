package com.chen.api.util.thread.study.chapter3.waitReleaseLock;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-05-08 12:00 AM
 */
public class Test {


    public static void main(String[] args) {
        Object lock = new Object();

        ThreadA threadA = new ThreadA(lock);
        threadA.setName("a");
        threadA.start();

        ThreadB threadB = new ThreadB(lock);
        threadB.setName("b");
        threadB.start();


    }
}
