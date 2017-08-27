package com.chen.designPattern.singleton;

/**
 * 饿汉式模式
 * Created by chenwj3 on 2017/2/28.
 */
public class Singleton2 {

    private Singleton2() {
    }

    private static Singleton2 singleton2 = new Singleton2();

    public static synchronized Singleton2 getSingleton2() {
        return singleton2;
    }



}
