package com.chen.api.util.thread.study.chapter3.stack1;

/**
 * @author chen weijie
 * @date 2018-05-10 1:09 AM
 */
public class ThreadP extends Thread {

    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.pushService();
    }


}
