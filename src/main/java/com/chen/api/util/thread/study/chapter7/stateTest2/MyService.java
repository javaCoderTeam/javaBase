package com.chen.api.util.thread.study.chapter7.stateTest2;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:01
 */
public class MyService {

    synchronized public static void serviceMethod() {
        try {
            System.out.println("线程：" + Thread.currentThread().getName() + "调用serviceMethod方法");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
