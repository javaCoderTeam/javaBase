package com.chen.api.util.thread.study.chapter4.conditionExecute;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition实现顺序执行
 *
 * @author :  chen weijie
 * @Date: 2018-05-21 01:11
 */
public class Run {
    private volatile  static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();


    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {

            try {
                lock.lock();
                while (nextPrintWho != 1) {
                    conditionA.await();
                }

                for (int i = 0; i < 3; i++) {
                    System.out.println("threadA:" + (i + 1));
                }

                nextPrintWho = 2;
                conditionB.signalAll();


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread() {


            @Override
            public void run() {
                lock.lock();

                try {
                    while (nextPrintWho != 2) {
                        conditionB.await();
                    }

                    for (int i = 0; i < 3; i++) {
                        System.out.println("threadB:" + (i + 1));
                    }
                    nextPrintWho = 3;
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread threadC = new Thread() {

            @Override
            public void run() {

                try {
                    lock.lock();
                    while (nextPrintWho != 3) {
                        conditionC.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("threadC:" + (i + 1));
                    }

                    nextPrintWho = 1;
                    conditionA.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        };


        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];

        for (int i = 0; i < 5; i++) {
            aArray[i] = new Thread(threadA);
            bArray[i] = new Thread(threadB);
            cArray[i] = new Thread(threadC);
            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }


    }


}
