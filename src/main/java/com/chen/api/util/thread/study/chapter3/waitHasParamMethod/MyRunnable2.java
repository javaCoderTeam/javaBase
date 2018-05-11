package com.chen.api.util.thread.study.chapter3.waitHasParamMethod;

/**
 * @author chen weijie
 * @date 2018-05-10 12:12 AM
 */
public class MyRunnable2 {


    static private Object object = new Object();

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {

            synchronized (object) {
                try {
                    System.out.println("wait begin:time==" + System.currentTimeMillis());
                    object.wait(5000);
                    System.out.println("wait begin:time==" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    static Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println("notify begin:time==" + System.currentTimeMillis());
                    object.notify();
                    System.out.println("notify begin:time==" + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    };


    public static void main(String[] args) {

        try {
            Thread t = new Thread(runnable);
            t.start();
            Thread.sleep(3000);
            Thread t2 = new Thread(runnable2);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
