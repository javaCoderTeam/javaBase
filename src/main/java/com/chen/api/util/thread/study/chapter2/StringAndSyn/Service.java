package com.chen.api.util.thread.study.chapter2.StringAndSyn;

/**
 * @author chen weijie
 * @date 2018-04-17 11:41 PM
 */
public class Service {


    public static void print(String stringParam) {
        try {
            synchronized (stringParam) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
