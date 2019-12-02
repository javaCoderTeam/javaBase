package com.chen.api.util.thread.mutex;


import com.chen.api.util.aqs.Mutex;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * https://www.cnblogs.com/chengxiao/archive/2017/07/24/7141160.html
 *
 * @author :  chen weijie
 * @Date: 2019-12-02 15:55
 */
public class TestMutex {


    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(31);


    private static int a = 0;

    private static Mutex mutex = new Mutex();

    public static void main(String args[]) throws BrokenBarrierException, InterruptedException {


        for (int i = 0; i < 30; i++) {

            Thread thread = new Thread(() -> {

                for (int j = 0; j < 10000; j++) {
                    // 没有同步措施
                    incremnet1();
                }
                try {
                    //等30个线程累加完毕
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        cyclicBarrier.await();
        System.out.println("加锁前，a=" + a);
        // 加锁后
        //重置
        cyclicBarrier.reset();

        a = 0;
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    increment2();//a++采用Mutex进行同步处理
                }
                try {
                    cyclicBarrier.await();//等30个线程累加完毕
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cyclicBarrier.await();
        System.out.println("加锁后，a=" + a);

    }


    public static void incremnet1() {
        a++;
    }

    public static void increment2() {
        mutex.lock();
        a++;
        mutex.unlock();
    }


}
