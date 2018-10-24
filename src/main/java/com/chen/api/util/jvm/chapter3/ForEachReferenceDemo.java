package com.chen.api.util.jvm.chapter3;

/**
 * 循环引用的垃圾回收
 *
 * @author :  chen weijie
 * @Date: 2018-10-24 9:20 AM
 */
public class ForEachReferenceDemo {


    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    //这个成员变量的唯一作用就是站点内存，一边在GC日志中可以看清楚是否被回收过

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {

        ForEachReferenceDemo objectA = new ForEachReferenceDemo();
        ForEachReferenceDemo objectB = new ForEachReferenceDemo();
        objectA.instance = objectA;
        objectB.instance = objectB;
        objectA = null;
        objectB = null;
        System.gc();


    }

    public static void main(String[] args) {
        testGC();
    }


}
