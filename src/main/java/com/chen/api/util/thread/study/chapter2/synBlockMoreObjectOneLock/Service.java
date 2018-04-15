package com.chen.api.util.thread.study.chapter2.synBlockMoreObjectOneLock;

/**
 * 静态同步
 *
 * @author chen weijie
 * @date 2018-04-16 1:54 AM
 */
public class Service {


    public static void printA() {
        synchronized (Service.class) {
            try {
                System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA()");
                Thread.sleep(3000);
                System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出printA()");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void printB() {
        synchronized (Service.class) {
            System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB()");
            System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出printB()");
        }
    }


}
