package com.chen.api.util.thread.study.chapter1.notShareVariable;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-09 3:08 AM
 */
public class TestNoShareVariable {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("线程1");
        MyThread thread2 = new MyThread("线程2");
        MyThread thread3 = new MyThread("线程3");
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        thread3.start();

    }
}
