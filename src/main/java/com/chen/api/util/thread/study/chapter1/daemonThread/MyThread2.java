package com.chen.api.util.thread.study.chapter1.daemonThread;

/**
 * @author :  chen weijie
 * @Date: 2020-07-10 11:17
 */
public class MyThread2 {

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(123);
            }
        },"测试线程").start();


    }



}
