package com.chen.test.designPattern;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:15
 */
public class Singleton {


    private Singleton() {
    }

    private static volatile Singleton singleton = null;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}
