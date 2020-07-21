package com.chen.api.util.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author :  chen weijie
 * @Date: 2019-06-13 00:15
 */
public class CountDownLatchTest {


    private static volatile CountDownLatch latch = new CountDownLatch(30);


    public static void main(String[] args) throws InterruptedException {


        System.out.println("主线程开始。。。。");

        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(new WorkerTask());
            thread.start();
            System.out.println("主线程等待。。。");
            System.out.println(Thread.currentThread().getName() + " before:" + latch.toString());

        }

        latch.await();
        System.out.println("await after:" + latch.toString());
        System.out.println("主线程继续.......");

    }


    static class WorkerTask implements Runnable {

        @Override
        public void run() {
            System.out.println("子线程任务正在执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " down:" + latch.toString());
            }


        }
    }


}
