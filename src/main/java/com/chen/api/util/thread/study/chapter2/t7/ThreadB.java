package com.chen.api.util.thread.study.chapter2.t7;

/**
 * @author chen weijie
 * @date 2018-04-15 1:24 AM
 */
public class ThreadB extends Thread {

    private Task task;

    public ThreadB(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }


}
