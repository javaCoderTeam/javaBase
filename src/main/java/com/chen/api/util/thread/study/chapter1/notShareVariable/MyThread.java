package com.chen.api.util.thread.study.chapter1.notShareVariable;

/**
 * 不共享变量
 *
 * @author chen weijie
 * @date 2018-04-09 3:02 AM
 */
public class MyThread extends Thread {

    private int i = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (i > 0) {
            i--;
            System.out.println(Thread.currentThread().getName() + "计算count==" + i);
        }

    }


}
