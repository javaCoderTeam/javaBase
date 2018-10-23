package com.chen.api.util.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xss2M -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author :  chen weijie
 * @Date: 2018-10-23 11:09 AM
 */
public class DistantsPoolMemoryStackOverflowDemo {


    public static void main(String[] args) {
        //使用list保持常量池引用，避免full GC回收常量池行为
        List<String> list = new ArrayList<>();
        int i = 0;
        for (; ; ) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
