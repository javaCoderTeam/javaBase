package com.chen.api.util.thread.study.chapter6.singleton1;

/**
 * 饿汉模式
 *
 * @author :  chen weijie
 * @Date: 2018-05-21 23:31
 */
public class MyObject {

    private static MyObject myObject = new MyObject();

    private MyObject() {
    }

    public static MyObject getInstance() {
        //此代码版本为立即加载，此代码的缺点是不能有其他实例变量
        //因为getInstance()没有同步，所以有可能出现线程安全的问题
        return myObject;
    }

}
