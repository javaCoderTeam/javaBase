package com.chen.algorithm.znn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: zhunn
 * @Date: 2021/1/26 13:55
 * @Description: 使用ReentrantLock与Condition
 */
public class ThreadTest4 {
    // 需要打印的资源: 0~100
    private static int count = 0;

    // 通过condition控制线程竞争
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();

    public static void main(String[] args) {

        // 启用线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 先从0，偶数开始
        executorService.execute(() -> {
            while (count <= 100) {
                try {
                    lock.lock();
                    System.out.println("偶: " + count);
                    count++;
                    // 把偶数线程阻塞
                    condition1.await();
                    // 把奇数线程唤醒
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        executorService.execute(() -> {
            while (count <= 100) {
                try {
                    lock.lock();
                    System.out.println("奇: " + count);
                    count++;
                    // 把偶数线程唤醒
                    condition1.signal();
                    // 把奇数线程阻塞
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        executorService.shutdown();
    }

}
