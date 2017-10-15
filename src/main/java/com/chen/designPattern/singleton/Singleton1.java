package com.chen.designPattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉式单例模式
 * Created by chenwj3 on 2017/2/28.
 */
//使用场景 http://blog.csdn.net/tanyujing/article/details/14160941
public class Singleton1 {

    private Singleton1() {
    }

    private static Singleton1 singleton1 = null;

    public static Singleton1 getSingleton1() {

        AtomicInteger  integer =new AtomicInteger();

        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }

        return singleton1;


    }

}
