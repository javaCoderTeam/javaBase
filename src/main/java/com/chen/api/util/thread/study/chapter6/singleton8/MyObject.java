package com.chen.api.util.thread.study.chapter6.singleton8;

/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:27
 */
public class MyObject {

    private static MyObject myObject = null;

    private MyObject() {
    }
    //静态代码块实现单例
    static {
        myObject = new MyObject();
    }

    public static MyObject getInstance() {
        return myObject;
    }


}
