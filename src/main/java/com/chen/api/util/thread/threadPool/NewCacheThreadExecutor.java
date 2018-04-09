package com.chen.api.util.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存线程池，当线程池大小超过了处理任务所需的线程，那么就会回收部分空闲（一般是60秒无执行）的线程，当有任务来时，又智能的添加新线程来执行。
 *
 * @author Chen WeiJie
 * @date 2018-04-03 17:28
 **/
public class NewCacheThreadExecutor {

    public static void main(String[] args) {

        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        //创建实现了Runnable接口对象
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();

    }
}
