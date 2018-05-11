package com.chen.api.util.thread.study.chapter3.p_r_test;

/**
 * @author chen weijie
 * @date 2018-05-10 12:42 AM
 */
public class ThreadC extends Thread {

    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }


}
