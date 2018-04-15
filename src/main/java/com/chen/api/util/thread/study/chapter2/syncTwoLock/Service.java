package com.chen.api.util.thread.study.chapter2.syncTwoLock;

/**
 * 静态同步
 *
 * @author chen weijie
 * @date 2018-04-16 1:54 AM
 */
public class Service {


    synchronized public static void printA() {

        try {
            System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA()");
            Thread.sleep(3000);
            System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出printA()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    synchronized public static void printB() {

        System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB()");
        System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出printB()");
    }

    synchronized public void printC() {

        System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printC()");
        System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出printC()");
    }

}
