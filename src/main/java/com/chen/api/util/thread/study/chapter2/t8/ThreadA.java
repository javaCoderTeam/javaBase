package com.chen.api.util.thread.study.chapter2.t8;

/**
 * @author chen weijie
 * @date 2018-04-15 1:54 AM
 */
public class ThreadA extends Thread {

    private Task task;

    public ThreadA(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }

}
