package com.chen.api.util.thread.study.chapter3.joinLong;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 23:53
 */
public class MyThread extends Thread {


    @Override
    public void run() {

        try {
            System.out.println("begin time:" + System.currentTimeMillis());
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
