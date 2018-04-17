package com.chen.api.util.thread.study.chapter2.twoStop2;

/**
 * @author chen weijie
 * @date 2018-04-18 12:04 AM
 */
public class Test {

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                Service service = new Service();
                service.methodA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Service service = new Service();
                service.methodB();
            }
        }).start();

    }

}
