package com.chen.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Chen WeiJie
 * @date 2020-04-23 17:02:02
 **/
public class TestMutex {


    private static CyclicBarrier barrier = new CyclicBarrier(31);

    private static int a = 0;

    private static Mutex mutex = new Mutex();


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {


        for (int i = 0; i < 30; i++) {

            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increment();
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        barrier.await();
        System.out.println("a===" + a);
        barrier.reset();
        a = 0;

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increment2();
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        barrier.await();
        System.out.println("a===" + a);


    }


    public static void increment() {

        a++;
    }


    public static void increment2() {
        mutex.lock();
        a++;
        mutex.unlock();
    }


}
