package com.chen.api.util.thread.study.chapter1.interruptThread;

/**
 * 中断线程
 *
 * @author chen weijie
 * @date 2018-04-09 11:40 PM
 */
public class InterruptThread extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 5000000; i++) {

            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            System.out.println("i====" + i);
        }

    }

}
