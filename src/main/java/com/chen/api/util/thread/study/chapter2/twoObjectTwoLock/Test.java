package com.chen.api.util.thread.study.chapter2.twoObjectTwoLock;

/**
 * @author chen weijie
 * @date 2018-04-12 1:44 AM
 */
public class Test {

    public static void main(String[] args) {

        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNum);
        threadA.start();
        HasSelfPrivateNum hasSelfPrivateNum1 = new HasSelfPrivateNum();
        ThreadB threadB = new ThreadB(hasSelfPrivateNum1);
        threadB.start();
    }

}
