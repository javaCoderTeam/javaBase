package com.chen.api.util.thread.study.chapter1.interruptThread;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-09 11:42 PM
 */
public class InterruptThreadTest {

    public static void main(String[] args) {

        InterruptThread thread =new InterruptThread();
        thread.start();
        try {
            Thread.sleep(10000);
            System.out.println("sleep-------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();


    }
}
