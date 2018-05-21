package com.chen.api.util.thread.study.chapter6.singleton7;

/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:21
 */
public class MyObject {

    //静态内部类
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }

}
