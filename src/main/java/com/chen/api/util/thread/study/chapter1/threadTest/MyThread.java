package com.chen.api.util.thread.study.chapter1.threadTest;

/**
 * 继承thread类的多线程
 *
 * @author chen weijie
 * @date 2018-04-08 1:20 AM
 */
public class MyThread extends Thread {

    private  int i = 10;
    @Override
    public void run() {
        i--;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "正在运行..i = "+i);
    }

}
