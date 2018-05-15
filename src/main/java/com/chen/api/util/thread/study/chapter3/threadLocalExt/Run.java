package com.chen.api.util.thread.study.chapter3.threadLocalExt;

/**
 * 解决初始值为null的问题。
 *
 * @author :  chen weijie
 * @Date: 2018-05-16 01:06
 */
public class Run {

    public static ThreadLocalExt threadLocalExt = new ThreadLocalExt();

    public static void main(String[] args) {

        if (threadLocalExt.get() == null) {
            threadLocalExt.set("我的值");
        }
        System.out.println(threadLocalExt.get());
        System.out.println(threadLocalExt.get());

    }


}
