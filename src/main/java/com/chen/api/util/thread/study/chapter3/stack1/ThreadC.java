package com.chen.api.util.thread.study.chapter3.stack1;

/**
 * @author chen weijie
 * @date 2018-05-10 1:09 AM
 */
public class ThreadC extends Thread {

    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.popService();
    }


}
