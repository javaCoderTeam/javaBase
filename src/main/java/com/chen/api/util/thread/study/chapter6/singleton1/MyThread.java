package com.chen.api.util.thread.study.chapter6.singleton1;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 23:36
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }

}
