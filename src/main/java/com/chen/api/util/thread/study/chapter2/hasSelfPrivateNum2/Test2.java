package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum2;

/**
 *
 *
 * @author chen weijie
 * @date 2018-04-12 1:08 AM
 */
public class Test2 {

    public static void main(String[] args) {
        HasPrivateNum2 hasPrivateNum = new HasPrivateNum2();
        ThreadA2 threadA = new ThreadA2(hasPrivateNum);
        threadA.start();
        ThreadB2 threadB = new ThreadB2(hasPrivateNum);
        threadB.start();
    }
}
