package com.chen.api.util.thread.study.chapter2.t6;

/**
 * @author chen weijie
 * @date 2018-04-14 6:43 PM
 */
public class MyThread2 extends Thread {


    private Task task;

    public MyThread2(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }

}
