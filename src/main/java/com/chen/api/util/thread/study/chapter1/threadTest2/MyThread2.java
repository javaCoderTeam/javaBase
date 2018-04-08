package com.chen.api.util.thread.study.chapter1.threadTest2;

/**
 * 测试执行start方法的顺序不代表代码的执行顺序
 *
 * @author chen weijie
 * @date 2018-04-08 1:29 AM
 */
public class MyThread2 extends Thread {

    private int i;

    public MyThread2(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
