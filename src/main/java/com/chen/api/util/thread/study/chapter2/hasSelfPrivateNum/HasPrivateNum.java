package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum;

/**
 * 方法的私有变量
 * 非线程安全问题存在于实例变量,如果是方法内部的私有变量则不存在非线程安全问题.
 *
 * @author chen weijie
 * @date 2018-04-12 12:55 AM
 */
public class HasPrivateNum {


    public void addI(String userName) {
        int num = 0;
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
