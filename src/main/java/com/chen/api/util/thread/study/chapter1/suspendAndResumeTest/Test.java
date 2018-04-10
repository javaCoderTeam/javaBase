package com.chen.api.util.thread.study.chapter1.suspendAndResumeTest;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-11 12:02 AM
 */
public class Test {

    public static void main(String[] args) {

        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(5000);
            //第一段
            thread.suspend();
            System.out.println("A=========" + System.currentTimeMillis() + ",n==========" + thread.getN());
            Thread.sleep(5000);
            System.out.println("A=========" + System.currentTimeMillis() + ",n==========" + thread.getN());
            //第二段
            thread.resume();
            Thread.sleep(5000);
            //第三段
            thread.suspend();
            System.out.println("B=========" + System.currentTimeMillis() + ",n==========" + thread.getN());
            Thread.sleep(5000);
            System.out.println("B=========" + System.currentTimeMillis() + ",n==========" + thread.getN());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
