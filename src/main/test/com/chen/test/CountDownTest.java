package com.chen.test;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * @author :  chen weijie
 * @Date: 2019-09-06 10:40
 */
public class CountDownTest {


    public static void main(String[] args) {


        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (countDownLatch.getClass()){
                    System.out.println(UUID.randomUUID().toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }

            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "执行程序....");


    }


}
