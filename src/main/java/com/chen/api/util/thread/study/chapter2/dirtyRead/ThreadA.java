package com.chen.api.util.thread.study.chapter2.dirtyRead;

/**
 * @author chen weijie
 * @date 2018-04-13 12:03 AM
 */
public class ThreadA extends Thread {

    private PublicVar var;

    public ThreadA(PublicVar var) {
        super();
        this.var = var;
    }

    @Override
    public void run() {
        super.run();
        var.setValue("B", "BBBBBB");
    }


}
