package com.chen.api.util.thread.study.chapter1.newRunnalble;

/**
 * 直接new Runnable创建多线程
 *
 * @author chen weijie
 * @date 2018-04-08 1:43 AM
 */
public class NewRunnable {


    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("124");
            }
        };
        new Thread(runnable).start();
    }
}
