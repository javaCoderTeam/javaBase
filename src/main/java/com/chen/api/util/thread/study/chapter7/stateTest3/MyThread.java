package com.chen.api.util.thread.study.chapter7.stateTest3;

/**
 * @author :  chen weijie
 * @Date: 2018-05-29 23:43
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        try {
            System.out.println("begin sleep");
            Thread.sleep(10000);
            System.out.println("end sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
