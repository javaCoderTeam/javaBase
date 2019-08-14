package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2019-05-31 00:35
 */
public class SingletonTest {


    private SingletonTest() {
    }

    /**
     * 使用volatile修饰声明的对象
     */
    private volatile static SingletonTest singletonTest = null;

    /**
     * 获取对象实例
     *
     * @return
     */
    public static SingletonTest getSingletonTest() {
        if (singletonTest == null) {
            synchronized (SingletonTest.class) {
                if (singletonTest == null) {
                    singletonTest = new SingletonTest();
                }
            }
        }
        return singletonTest;
    }
}
