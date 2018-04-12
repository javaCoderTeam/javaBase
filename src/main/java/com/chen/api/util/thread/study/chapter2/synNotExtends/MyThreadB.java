package com.chen.api.util.thread.study.chapter2.synNotExtends;

/**
 * @author chen weijie
 * @date 2018-04-13 1:11 AM
 */
public class MyThreadB extends Thread {

    private Sub sub;

    public MyThreadB(Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }


}
