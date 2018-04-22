package com.chen.api.util.thread.study.chapter2.atomicIntegerTest;

/**
 * @author chen weijie
 * @date 2018-04-22 11:32 PM
 */
public class Run {


    public static void main(String[] args) {

        AddCountThread addCountThread = new AddCountThread();

        Thread thread1 = new Thread(addCountThread);
        thread1.start();
        Thread thread2 = new Thread(addCountThread);
        thread2.start();
        Thread thread3 = new Thread(addCountThread);
        thread3.start();
        Thread thread4 = new Thread(addCountThread);
        thread4.start();

    }

}
