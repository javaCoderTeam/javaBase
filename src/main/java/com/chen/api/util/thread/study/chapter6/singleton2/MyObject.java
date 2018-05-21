package com.chen.api.util.thread.study.chapter6.singleton2;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 23:38
 */
public class MyObject {

    private static MyObject myObject = null;

    private MyObject() {
    }

    //懒汉模式，在多线程的情况下会出现同步问题。
    public static MyObject getInstance() {
        try {
            if (myObject == null) {
                Thread.sleep(1000);
                myObject = new MyObject();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }


}
