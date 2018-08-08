package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2018-05-31 00:20
 */
public class TestThread {

    public static void main(String[] args) {
        System.out.println("主线程ID:" + Thread.currentThread().getId());
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.run();
    }

    static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("name:" + name + " 子线程ID:" + Thread.currentThread().getId());
        }
    }

}
