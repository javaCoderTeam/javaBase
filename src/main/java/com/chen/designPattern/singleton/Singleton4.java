package com.chen.designPattern.singleton;

/**
 * @author :  chen weijie
 * @Date: 2019-11-11 14:14
 */
public class Singleton4 {

    private Singleton4(){}

    private volatile static Singleton4 singleton4;


    public static Singleton4 getGetInstance() {

        if (singleton4 == null) {

            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }







}
