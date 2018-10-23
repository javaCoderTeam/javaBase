package com.chen.api.util.jvm.chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *
 * -verbose:gc -Xms20M -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author :  chen weijie
 * @Date: 2018-10-23 9:28 PM
 */
public class DirectMemoryOOMError {


    public static final int _1MB =1024*1024;
    public static void main(String[] args) throws IllegalAccessException {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }

    }

}
