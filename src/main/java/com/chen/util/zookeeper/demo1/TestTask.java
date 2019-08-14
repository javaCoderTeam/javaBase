package com.chen.util.zookeeper.demo1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * @author :  chen weijie
 * @Date: 2019-06-10 16:25
 */
public class TestTask implements Runnable {


    public static final int NUM = 10;

    private static CountDownLatch cdl = new CountDownLatch(10);

    private Lock lock = new DistributedLock();


    public void getInfo() {

        lock.lock();
        try {
            System.out.println("执行操作。。。。。");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("执行操作。。。。。end");
    }


    @Override
    public void run() {

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getInfo();
    }


    public static void main(String[] args) {

        for (int i = 1; i <= NUM; i++) {
            // 按照线程数迭代实例化线程
            new Thread(
                    new TestTask()
            )
                    .start();
            // 创建一个线程，倒计数器减1
            cdl.countDown();
        }


    }


}
