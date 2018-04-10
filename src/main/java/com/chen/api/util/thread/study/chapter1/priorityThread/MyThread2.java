package com.chen.api.util.thread.study.chapter1.priorityThread;

/**
 * @author chen weijie
 * @date 2018-04-11 1:10 AM
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread2 run priority is " + this.getPriority());
    }

}
