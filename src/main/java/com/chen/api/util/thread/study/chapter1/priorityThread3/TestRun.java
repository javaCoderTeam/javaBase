package com.chen.api.util.thread.study.chapter1.priorityThread3;

/**
 * @author chen weijie
 * @date 2018-04-11 1:42 AM
 */
public class TestRun {


    public static void main(String[] args) {

        try {
            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.setPriority(Thread.NORM_PRIORITY - 2);
            a.start();
            b.setPriority(Thread.NORM_PRIORITY + 2);
            b.start();
            Thread.sleep(20000);

            a.stop();
            b.stop();
            System.out.println("a=============" + a.getCount());
            System.out.println("b=============" + b.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
