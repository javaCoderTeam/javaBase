package com.chen.api.util.thread.study.chapter3.join_interrupt;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 01:28
 */
public class ThreadB extends Thread {


    @Override
    public void run() {

        try {
            ThreadA threadA = new ThreadA();
            threadA.start();
            threadA.join();
            System.out.println("threadB 在end处打印了。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("threadB 在catch处打印了。。");

        }
    }

}
