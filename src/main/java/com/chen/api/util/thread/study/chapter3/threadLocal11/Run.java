package com.chen.api.util.thread.study.chapter3.threadLocal11;

/**
 * @author :  chen weijie
 * @Date: 2018-05-16 00:35
 */
public class Run {


    public static final ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {

        if (threadLocal.get() == null) {
            System.out.println("从未放过值。。");
            threadLocal.set("我的值");
        }
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());

    }

}
