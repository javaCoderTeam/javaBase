package com.chen.api.util.thread.study.chapter1.runnableTest;

/**
 * 测试实现Runnable接口实现多线程
 *
 * @author chen weijie
 * @date 2018-04-08 1:37 AM
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "...running!");
    }
}
