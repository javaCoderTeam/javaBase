package com.chen.api.util.thread.study.chapter3.join_test;

/**
 *
 * 方法join的作用是使所属的线程对象X正常执行run方法中的任务，而使当前线程Z进行无限制的阻塞，等待线程X销毁后在急需执行线程Z后的代码。
 *
 *
 * @author :  chen weijie
 * @Date: 2018-05-15 01:04
 */
public class Run2 {


    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    int secondValue = (int) (Math.random() * 10000);
                    System.out.println(secondValue);
                    System.out.println("==========" + Thread.currentThread().getName());
                    Thread.sleep(secondValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            Thread thread = new Thread(runnable);
            thread.start();
            thread.join();
            System.out.println("==========2 " + Thread.currentThread().getName());
            System.out.println("我想等待thread执行完毕才执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
