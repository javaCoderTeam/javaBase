package com.chen.api.util.thread.study.chapter7.threadGroup;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:38
 */
public class Run {

    public static void main(String[] args) {

        ThreadA runableA = new ThreadA();
        ThreadB runableB = new ThreadB();

        ThreadGroup group = new ThreadGroup("我的线程组");

        Thread aThread = new Thread(group, runableA);
        Thread bThread = new Thread(group, runableB);

        aThread.start();
        bThread.start();

        System.out.println("活动的线程数：" + group.activeCount());
        System.out.println("线程组的名称：" + group.getName());

    }


}
