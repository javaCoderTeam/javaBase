package com.chen.api.util.thread.study.chapter7.stateTest3;

/**
 * @author :  chen weijie
 * @Date: 2018-05-29 23:45
 */
public class Run {

    public static void main(String[] args) {

        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            System.out.println("thread state:" + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
