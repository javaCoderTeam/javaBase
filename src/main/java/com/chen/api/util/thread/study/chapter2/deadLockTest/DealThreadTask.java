package com.chen.api.util.thread.study.chapter2.deadLockTest;

/**
 * @author chen weijie
 * @date 2018-04-18 12:11 AM
 */
public class DealThreadTask implements Runnable {

    public String userName;
    public Object lock1 = new Object();
    public Object lock2 = new Object();
    public void setFlag(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        if (userName.equals("a")) {
            synchronized (lock1) {
                System.out.println("userName==" + userName);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lock2) {
                System.out.println("按lock1--->lock2的代码执行了..");
            }
        }

        if (userName.equals("b")) {
            synchronized (lock2) {
                System.out.println("userName========" + userName);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lock1) {
                System.out.println("按lock2--->lock1的代码执行了..");
            }
        }
    }
}
