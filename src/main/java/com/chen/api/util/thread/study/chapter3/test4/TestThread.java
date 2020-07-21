package com.chen.api.util.thread.study.chapter3.test4;

/**
 * @author :  chen weijie
 * @Date: 2020-07-11 18:40
 */
public class TestThread {

    public static void main(String[] args) {

        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.setName("threadA");
        threadA.start();
        ThreadB threadB = new ThreadB(lock);
        threadB.setName("threadB");
        threadB.start();


    }


}
