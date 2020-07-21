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
//            myThread.setDaemon(true);
//            myThread.start();
//
//            System.out.println("我离开daemon对象也不在打印了,也就是停止了");


            // thread传入Mythread对象，因为myThread继承了thread，而thread实现了runnable接口
            Thread thread = new Thread(myThread,"测试传入thread的线程");
            thread.start();
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }






    }
}
