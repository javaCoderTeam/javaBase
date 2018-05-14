package com.chen.api.util.thread.study.chapter3.join_interrupt;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 01:28
 */
public class ThreadA extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            String a = new String("a");
            System.out.println("ThreadA  test.....");
        }

    }


}
