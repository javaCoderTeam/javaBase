package com.chen.api.util.thread.study.chapter1.notSafeThread;

/**
 * 测试类
 *
 * @author Chen WeiJie
 * @date 2018-04-09 16:17
 **/
public class TestNotSafeThread {


    public static void main(String[] args) {

        ALogin thread1 = new ALogin();
        thread1.start();
        BLogin thread2 = new BLogin();
        thread2.start();
    }

}
