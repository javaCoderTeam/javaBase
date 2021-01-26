package com.chen.algorithm.znn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: zhunn
 * @Date: 2021/1/26 13:56
 * @Description: 仅使用ReentrantLock
 */
public class ThreadTest5 {
    // 需要打印的资源: 0~100
    private static int count = 0;

    // 是否执行打印的标志
    private static volatile boolean flag = false;

    // 通过加锁控制线程竞争
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        // 启用线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 先从0，偶数开始
        executorService.execute(() -> {
            while (count <= 100) {
                if (!flag) {
                    try {
                        lock.lock();
                        System.out.println("偶: " + count);
                        count++;
                        // 只有flag变为true了，此线程才不会接着执行，将争夺权给奇数线程
                        flag = true;
                    } finally {
                        lock.unlock();
                    }
                } else {
                    // 防止线程空转
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(() -> {
            while (count <= 100) {
                // 当偶数线程执行后flag变为true，此线程可以执行了
                if (flag) {
                    try {
                        lock.lock();
                        System.out.println("奇: " + count);
                        count++;
                        // 让出CPU
                        flag = false;
                    } finally {
                        lock.unlock();
                    }
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.shutdown();
    }

}
