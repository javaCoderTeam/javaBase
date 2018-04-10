package com.chen.api.util.thread.threadPool;

import java.util.concurrent.*;

/**
 * @author Chen WeiJie
 * @date 2018-04-10 18:05
 **/
public class ThreadPoolExecutorTest {


    public void getThreadPool(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {


        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);


        threadPool.prestartAllCoreThreads();


    }


}
