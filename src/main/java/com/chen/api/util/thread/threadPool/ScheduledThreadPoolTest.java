package com.chen.api.util.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author :  chen weijie
 * @Date: 2019-10-22 23:27
 */
public class ScheduledThreadPoolTest {


    public static void main(String[] args) {

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

        pool.scheduleAtFixedRate((Runnable) () -> System.out.println(123), 1, 5, TimeUnit.SECONDS);

    }

}
