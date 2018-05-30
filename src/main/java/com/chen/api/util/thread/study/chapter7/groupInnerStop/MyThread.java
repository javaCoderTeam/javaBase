package com.chen.api.util.thread.study.chapter7.groupInnerStop;


/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:47
 */
public class MyThread extends Thread {


    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {

        System.out.println("threadName:" + Thread.currentThread().getName() + "准备开始循环了");
        while (!Thread.currentThread().isInterrupted()) {

        }

        System.out.println("threadName:" + Thread.currentThread().getName() + "结束循环了。");

    }


}
