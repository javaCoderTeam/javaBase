package com.chen.api.util.thread.study.chapter6.singleton4;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 23:54
 */
public class MyObject {

    private static MyObject myObject = null;

    private MyObject() {
    }

    public static MyObject getInstance() {
        //同步代码块 getInstance方法中的所有代码都上锁，这样做也会降低运行效率
        synchronized (MyObject.class) {
            if (myObject == null) {
                myObject = new MyObject();
            }
        }
        return myObject;
    }
}
