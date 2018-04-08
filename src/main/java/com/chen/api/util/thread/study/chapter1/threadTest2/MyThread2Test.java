package com.chen.api.util.thread.study.chapter1.threadTest2;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-08 1:32 AM
 */
public class MyThread2Test {

    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2(1);
        MyThread2 t2 = new MyThread2(2);
        MyThread2 t3 = new MyThread2(3);
        MyThread2 t4 = new MyThread2(4);
        MyThread2 t5 = new MyThread2(5);
        MyThread2 t6 = new MyThread2(6);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
