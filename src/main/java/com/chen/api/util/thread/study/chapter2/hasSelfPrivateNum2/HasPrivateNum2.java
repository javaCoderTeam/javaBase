package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum2;

/**
 * 方法的私有变量
 * 多个线程共同访问一个对象中的实例变量,则可能出现非线程安全问题.如果对象仅有一个实例变量,则可能出现覆盖的情况
 *
 * @author chen weijie
 * @date 2018-04-12 12:55 AM
 */
public class HasPrivateNum2 {

    int num = 0;

    public void addI(String userName) {
        try {
            if (userName.equals("a")) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(userName + " ,num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
