package com.chen.api.util.thread.study.chapter3.waitHasParamMethod;

/**
 * @author chen weijie
 * @date 2018-05-10 12:12 AM
 */
public class MyRunnable {


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

    public static void main(String[] args) {

        Thread t =new Thread(runnable);
        t.start();
    }

}
