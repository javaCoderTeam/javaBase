package com.chen.api.util.thread.study.chapter3.joinLong;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 23:59
 */
public class Test {

    public static void main(String[] args) {

        try {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.join(2000);
//            Thread.sleep(2000);
            System.out.println("end   time:" + System.currentTimeMillis());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
