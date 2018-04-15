package com.chen.api.util.thread.study.chapter2.test2;

/**
 * @author chen weijie
 * @date 2018-04-16 1:36 AM
 */
public class MyObject {


    synchronized public void speedPrintString() {
        System.out.println("speedPrintString___________getLock,time===" + System.currentTimeMillis() + ",threadName:" + Thread.currentThread().getName());
        System.out.println("----------------");
        System.out.println("speedPrintString___________releaseLock,time===" + System.currentTimeMillis() + ",threadName:" + Thread.currentThread().getName());


    }


}
