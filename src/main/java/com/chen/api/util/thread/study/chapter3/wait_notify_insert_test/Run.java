package com.chen.api.util.thread.study.chapter3.wait_notify_insert_test;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 00:49
 */
public class Run {


    public static void main(String[] args) {
        DBTooles dbTooles = new DBTooles();

        for (int i = 0; i < 20; i++) {
            ThreadA threadA = new ThreadA(dbTooles);
            ThreadB threadB = new ThreadB(dbTooles);
            threadA.start();
            threadB.start();
        }

    }


}
