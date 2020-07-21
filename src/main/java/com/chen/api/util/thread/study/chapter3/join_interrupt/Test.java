package com.chen.api.util.thread.study.chapter3.join_interrupt;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 01:34
 */
public class Test {


    public static void main(String[] args) {
        try {
            ThreadB threadB = new ThreadB();
            threadB.start();
            Thread.sleep(100);
            ThreadC threadC = new ThreadC(threadB);
            threadC.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
