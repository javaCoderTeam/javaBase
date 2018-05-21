package com.chen.api.util.thread.study.chapter6.singleton8;

/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:28
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            super.run();
            System.out.println(MyObject.getInstance().hashCode());
        }

    }
}
