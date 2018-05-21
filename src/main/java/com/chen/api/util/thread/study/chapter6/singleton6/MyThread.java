package com.chen.api.util.thread.study.chapter6.singleton6;

/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:15
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }

}
