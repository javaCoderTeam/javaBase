package com.chen.api.util.thread.study.chapter1.shareVariable;

/**
 * 共享变量(优化类,加同步锁)
 * 多个线程之间进行同步,按顺序排队的方式进行减1操作
 *
 * @author chen weijie
 * @date 2018-04-09 3:16 AM
 */
public class ShareVariableThread2 extends Thread {

    private int i = 10;

    @Override
    synchronized public void run() {
        i--;
        System.out.println(Thread.currentThread().getName() + "计算,count=" + i);
    }
}
