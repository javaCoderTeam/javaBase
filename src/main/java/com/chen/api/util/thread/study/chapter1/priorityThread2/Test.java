package com.chen.api.util.thread.study.chapter1.priorityThread2;

/**
 * @author chen weijie
 * @date 2018-04-11 1:27 AM
 */
public class Test {


    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.setPriority(10);
        thread.start();
        MyThread2 thread2 = new MyThread2();
        thread.setPriority(1);
        thread2.start();
    }


}
