package com.chen.api.util.thread.study.chapter2.synNotExtends;

import com.chen.api.util.thread.threadPool.MyThread;

/**
 * @author chen weijie
 * @date 2018-04-13 1:11 AM
 */
public class MyThreadA extends Thread {

    private Sub sub;

    public MyThreadA(Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }


}
