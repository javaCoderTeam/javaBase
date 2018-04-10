package com.chen.api.util.thread.study.chapter1.suspendResumeDealLock;

/**
 * @author chen weijie
 * @date 2018-04-11 12:16 AM
 */
public class Test {

    public static void main(String[] args) {

        final SynchronizedObject object = new SynchronizedObject();

        try {

            //线程使用的另一种方式
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };

            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);


            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2 线程启动了,进不了printString方法");
                    System.out.println("因为printString 方法被a线程锁定并且永远suspend暂停了");
                    object.printString();
                }
            };

            thread2.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
