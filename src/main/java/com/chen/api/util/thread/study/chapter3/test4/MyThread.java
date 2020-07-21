package com.chen.api.util.thread.study.chapter3.test4;

/**
 * @author :  chen weijie
 * @Date: 2020-07-11 18:11
 */
public class MyThread {






    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 1000; i++) {
                            if (i % 2 == 0) {
                                System.out.println(Thread.currentThread().getName() + ",i=" + i);
                            }
                            try {
                                lock.wait();
                                lock.notify();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        },"thread-A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 1000; i++) {
                        if (i % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() + ",i=" + i);
                        }
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        },"thread-B").start();




    }










}
