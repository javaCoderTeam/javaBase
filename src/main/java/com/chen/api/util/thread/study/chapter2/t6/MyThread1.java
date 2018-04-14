package com.chen.api.util.thread.study.chapter2.t6;

/**
 * @author chen weijie
 * @date 2018-04-14 6:43 PM
 */
public class MyThread1 extends Thread {


    private Task task;

    public MyThread1(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }

}
