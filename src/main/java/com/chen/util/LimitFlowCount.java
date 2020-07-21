package com.chen.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :  chen weijie
 * @Date: 2020-06-09 19:30
 */
public class LimitFlowCount {


    /**
     * 每秒重置计数器
     */
    private static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                counter.set(0);
            }
        },0,1, TimeUnit.SECONDS);
    }

}
