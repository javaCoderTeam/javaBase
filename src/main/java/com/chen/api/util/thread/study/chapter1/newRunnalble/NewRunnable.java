package com.chen.api.util.thread.study.chapter1.newRunnalble;

/**
 * 直接new Runnable创建多线程
 *
 * @author chen weijie
 * @date 2018-04-08 1:43 AM
 */
public class NewRunnable {


    public static void main(String[] args) {

        //创建线程的一种方式
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("124");
            }
        };
        new Thread(runnable).start();

        //创建线程的另一种方式
        Thread thread = new Thread() {

            @Override
            public void run() {
                System.out.println("Thread 直接创建线程 ");
            }
        };
        thread.start();

    }
}
