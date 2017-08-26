package com.chen.designPattern.singleton;

/**
 * 懒汉式单例模式
 * Created by chenwj3 on 2017/2/28.
 */
public class Singleton1 {

    private Singleton1() {
    }

    private static Singleton1 singleton1 = null;

    public static Singleton1 getSingleton1() {

        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }

        return singleton1;


    }

}
