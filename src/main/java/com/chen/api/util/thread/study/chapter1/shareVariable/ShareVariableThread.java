package com.chen.api.util.thread.study.chapter1.shareVariable;

/**
 * 共享变量
 *
 * @author chen weijie
 * @date 2018-04-09 3:16 AM
 */
public class ShareVariableThread extends Thread {

    private int i = 10;

    @Override
    public void run() {
        i--;
        System.out.println(Thread.currentThread().getName() + "计算,count=" + i);
    }
}
