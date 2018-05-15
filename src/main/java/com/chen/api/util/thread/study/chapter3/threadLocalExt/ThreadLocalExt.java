package com.chen.api.util.thread.study.chapter3.threadLocalExt;

/**
 * @author :  chen weijie
 * @Date: 2018-05-16 01:04
 */
public class ThreadLocalExt extends ThreadLocal {



    @Override
    public Object initialValue(){

        return "我是init value";

    }

}
