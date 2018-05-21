package com.chen.api.util.thread.study.chapter6.singleton5;


/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:01
 */
public class MyObject {

    private static MyObject myObject = null;

    private MyObject() {
    }

    //虽然对实例化对象的关键代码进行了同步，从代码结构上看效率得到了提升，但是无法解决多线程安全的问题。
    //同时又多个线程访问if (myObject == null) ，得到的结果可能不一样。
    public static MyObject getInstance() {
        if (myObject == null) {
            synchronized (MyObject.class) {
                myObject = new MyObject();
            }
        }
        return myObject;
    }

}
