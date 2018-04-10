package com.chen.api.util.thread.study.chapter1.daemonThread;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-11 2:01 AM
 */
public class Test {


    public static void main(String[] args) {

        try {
            MyThread myThread = new MyThread();
            myThread.setDaemon(true);
            myThread.start();
            Thread.sleep(10000);

            System.out.println("我离开daemon对象也不在打印了,也就是停止了");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
