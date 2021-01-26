package com.chen.algorithm.znn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: zhunn
 * @Date: 2021/1/26 13:55
 * @Description: 使用synchronized
 */
public class ThreadTest3 {
    // 需要打印的资源: 0~100
    private static int count = 0;

    private static Object lock = new Object();

    public static void main(String[] args) {

        // 启用线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 先从0，偶数开始
        executorService.execute(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    try {
                        System.out.println("偶: " + count);
                        count++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        // 释放奇数线程
                        lock.notifyAll();
                        if (count <= 100) {
                            try {
                                // 防止偶数线程继续执行
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        executorService.execute(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    try {
                        System.out.println("奇: " + count);
                        count++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.notifyAll();
                        if (count <= 100) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        executorService.shutdown();
    }

}
