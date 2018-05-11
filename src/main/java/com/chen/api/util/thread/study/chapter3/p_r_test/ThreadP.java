package com.chen.api.util.thread.study.chapter3.p_r_test;

/**
 * @author chen weijie
 * @date 2018-05-10 12:42 AM
 */
public class ThreadP extends Thread {

    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }


}
