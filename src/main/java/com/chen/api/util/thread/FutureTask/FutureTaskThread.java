package com.chen.api.util.thread.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * User: chenweijie
 * Date: 10/17/17
 * Time: 11:01 PM
 * Description: 创建线程的三种方式
 */
public class FutureTaskThread {


    public static void main(String[] args) throws Exception {

        //第一种方式
        Thread thread1 = new Thread() {

            @Override
            public void run() {
                System.out.println("new Thread 1");
            }
        };
        thread1.start();
        System.out.println(thread1.getName());

        //第二种方式
        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread2");
            }
        });
        thread2.start();
        System.out.println(Thread.currentThread().getName());


        //第三种方式
        FutureTask<String> ft = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("new Thread 3");
                return "thread 3";
            }
        });

        Thread thread3 = new Thread(ft);
        thread3.start();
        String result = ft.get();
        System.out.println(result);
    }





}
