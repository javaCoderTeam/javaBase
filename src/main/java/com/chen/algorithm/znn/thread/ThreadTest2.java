package com.chen.algorithm.znn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: zhunn
 * @Date: 2021/1/26 13:54
 * @Description: 使用AtomicInteger
 */
public class ThreadTest2 {
    private static AtomicInteger count = new AtomicInteger(0);

    private volatile static boolean flag = true;

    public static void main(String[] args) {

        // 启用线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 先从0，偶数开始
        executorService.execute(() -> {
            while (count.get() <= 100) {
                if (flag) {
                    System.out.println("偶数：" + count.getAndIncrement());
                    flag = false;
                }
            }
        });
        executorService.execute(() -> {
            while (count.get() <= 100) {
                if (!flag) {
                    System.out.println("奇数：" + count.getAndIncrement());
                    flag = true;
                }
            }
        });
        executorService.shutdown();
    }

}
