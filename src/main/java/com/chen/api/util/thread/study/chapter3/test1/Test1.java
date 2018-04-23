package com.chen.api.util.thread.study.chapter3.test1;

/**
 * 没有对象监视器导致抛出异常
 *
 * @author :  chen weijie
 * @Date: 2018-04-24 00:01
 */
public class Test1 {

    public static void main(String[] args) {

        try {
            String newString = new String("a");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


}
