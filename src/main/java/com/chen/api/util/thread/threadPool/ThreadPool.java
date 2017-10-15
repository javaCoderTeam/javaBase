package com.chen.api.util.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenweijie
 * @Date 2017/9/17 23:34
 */
public class ThreadPool {


    public static void main(String[] args) {

        ExecutorService service =Executors.newSingleThreadExecutor();

        ExecutorService service2 = Executors.newCachedThreadPool();

        ExecutorService service3 =Executors.newFixedThreadPool(10);

//        new ThreadPoolExecutor(1,1,1,1,1);
    }

}
