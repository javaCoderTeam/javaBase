package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum2;

/**
 * 对象中的变量是实例变量,但是方法是同步方法
 *
 * @author chen weijie
 * @date 2018-04-12 1:23 AM
 */
public class SynHasPrivateNum {


    private int i = 0;

    synchronized public void addI(String userName) {
        if ("a".equals(userName)) {
            i = 100;
            System.out.println("a set over");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            i = 200;
            System.out.println("b set over");
        }

        System.out.println(userName + " ,num=" + i);
    }

}
