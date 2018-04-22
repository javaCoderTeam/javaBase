package com.chen.api.util.thread.study.chapter2.volatileTestThread;

/**
 * 运行的结果不是10000
 *
 * @author chen weijie
 * @date 2018-04-22 11:01 PM
 */
public class Run {

    public static void main(String[] args) {

        MyThread[] myThreadArray = new MyThread[100];

        for (int i = 0; i < 100; i++) {
            myThreadArray[i] = new MyThread();
        }

        for (int i = 0; i < 100; i++) {
            myThreadArray[i].start();
        }
    }

}
