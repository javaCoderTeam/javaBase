package com.chen.api.util.thread.study.chapter3.p_r_test;

/**
 * 生产消费者模式
 *
 * @author chen weijie
 * @date 2018-05-10 12:44 AM
 */
public class Test {

    public static void main(String[] args) {

        String lock = new String("");

        C c = new C(lock);
        P p = new P(lock);

        ThreadC threadC = new ThreadC(c);
        ThreadP threadP = new ThreadP(p);
        threadP.start();
        threadC.start();

    }

}
