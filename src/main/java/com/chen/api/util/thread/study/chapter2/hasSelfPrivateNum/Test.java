package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum;


/**
 * @author chen weijie
 * @date 2018-04-12 1:08 AM
 */
public class Test {

    public static void main(String[] args) {
        HasPrivateNum hasPrivateNum = new HasPrivateNum();
        ThreadA threadA = new ThreadA(hasPrivateNum);
        threadA.start();
        ThreadB threadB = new ThreadB(hasPrivateNum);
        threadB.start();
    }
}
