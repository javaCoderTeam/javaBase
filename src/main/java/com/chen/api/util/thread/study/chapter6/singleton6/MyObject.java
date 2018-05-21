package com.chen.api.util.thread.study.chapter6.singleton6;

/**
 * @author :  chen weijie
 * @Date: 2018-05-22 00:14
 */
public class MyObject {

    private volatile static MyObject myObject = null;

    private MyObject() {
    }

    //使用DCL双检查锁机制，既保证了同步代码的异步执行，又保证了单例的效果。
    public static MyObject getInstance() {
        if (myObject == null) {
            synchronized (MyObject.class) {
                myObject = new MyObject();
            }
        }
        return myObject;
    }


}
