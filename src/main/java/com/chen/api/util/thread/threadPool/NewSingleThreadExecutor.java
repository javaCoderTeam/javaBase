package com.chen.api.util.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单个线程的线程池，单线程串行执行任务
 *
 * @author Chen WeiJie
 * @date 2018-04-03 16:58
 **/
public class NewSingleThreadExecutor {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newSingleThreadExecutor();

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.shutdown();

    }
}
