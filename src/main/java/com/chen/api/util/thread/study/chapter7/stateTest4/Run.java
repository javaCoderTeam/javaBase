package com.chen.api.util.thread.study.chapter7.stateTest4;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:21
 */
public class Run {


    public static void main(String[] args) {


        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            System.out.println("t的状态：" + myThread.getState());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
