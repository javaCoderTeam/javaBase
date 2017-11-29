package com.chen.api.util.thread.semaphor;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 信号量-根据阀值做一些访问控制
 *
 * @author Chen WeiJie
 * @date 2017-11-22 17:00
 **/
public class SemaphoreTest {


    private final static Semaphore MAX_SEMA_PHORE = new Semaphore(10);


    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {

            final int num = i;

            final Random random = new Random();

            new Thread(() -> {
                boolean acquired = false;
                try {
                    MAX_SEMA_PHORE.acquire();
                    acquired = true;
                    System.out.println("我是线程：" + num + " 我获得了使用权！" + new Date());
                    long time = 1000 * Math.max(1, Math.abs(random.nextInt() % 10));
                    Thread.sleep(time);
                    System.out.println("我是线程：" + num + " 我执行完了！" + new Date());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (acquired) {
                        MAX_SEMA_PHORE.release();
                    }
                }
            }).start();
        }
    }






}
