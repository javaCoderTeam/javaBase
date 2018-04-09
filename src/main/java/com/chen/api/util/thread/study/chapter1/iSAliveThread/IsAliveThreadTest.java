package com.chen.api.util.thread.study.chapter1.iSAliveThread;

/**
 * 测试类
 *
 * @author Chen WeiJie
 * @date 2018-04-09 18:47
 **/
public class IsAliveThreadTest {

    public static void main(String[] args) {
        IsAliveThread isAliveThread = new IsAliveThread();
        isAliveThread.setName("A");
        isAliveThread.start();

    }
}
