package com.chen.api.util.thread.study.chapter2.hasSelfPrivateNum2;

/**
 * @author chen weijie
 * @date 2018-04-12 1:28 AM
 */
public class TestSyn {

    public static void main(String[] args) {

        SynHasPrivateNum numRef = new SynHasPrivateNum();
        ThreadA3 threadA3 = new ThreadA3(numRef);
        ThreadB3 threadB3 = new ThreadB3(numRef);
        threadA3.start();
        threadB3.start();


    }
}
