package com.chen.api.util.thread.study.chapter2.twoStop2;

/**
 * 解决 twoStop中的死锁问题
 *
 * @author chen weijie
 * @date 2018-04-17 11:56 PM
 */
public class Service {

    Object object = new Object();

    public void methodA() {
        synchronized (object) {
            System.out.println("methodA begin..");
            boolean isContinueRun = true;
            while (isContinueRun) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("method while execute.....");
            }
            System.out.println("methodA end");
        }
    }

    synchronized public void methodB() {

        System.out.println("methodB begin");
        System.out.println("methodB end");

    }


}
