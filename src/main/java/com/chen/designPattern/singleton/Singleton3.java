package com.chen.designPattern.singleton;

/**
 * （双重校验锁）
 * @Author chenweijie
 * @Date 2017/9/15 1:16
 */
public class Singleton3 {


    private Singleton3() {
    }

    private volatile static Singleton3 singleton3;

    public static Singleton3 getSingleton3() {

        if (singleton3 == null) {
            synchronized (Singleton3.class) {
                if (singleton3 == null) {
                    singleton3 = new Singleton3();

                }

            }
        }
        return singleton3;

    }

}
