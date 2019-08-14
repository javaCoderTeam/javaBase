package com.chen.api.util.jvm.gc;

/**
 * @author :  chen weijie
 * @Date: 2019-05-30 00:05
 */
public class GCTest {


    private Object instance = null;
    private static final int _10M = 10 * 1 << 20;
    // 一个对象占10M，方便在GC日志中看出是否被回收
    private byte[] bigSize = new byte[_10M];

    public static void main(String[] args) {
        GCTest objA = new GCTest();
        GCTest objB = new GCTest();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }


}
