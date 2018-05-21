package com.chen.api.util.thread.study.chapter6.singleton3;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 23:48
 */
public class MyObject {


    private static MyObject myObject = null;

    private MyObject() {
    }

    //整个方法上锁，同步方法的效率太低了
    synchronized public static MyObject getInstance() {
        try {
            if (myObject == null) {
                Thread.sleep(2000);
                myObject = new MyObject();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }


}
