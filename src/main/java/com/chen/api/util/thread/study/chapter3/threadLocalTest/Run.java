package com.chen.api.util.thread.study.chapter3.threadLocalTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-16 00:50
 */
public class Run {

    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();

        for (int i = 0; i < 200; i++) {

            Tools.t1.set("main thread :" + (i + 1));
            System.out.println("main thread get:" + Tools.t1.get());

        }


    }

}
