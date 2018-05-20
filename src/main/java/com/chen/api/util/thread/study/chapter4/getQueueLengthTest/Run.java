package com.chen.api.util.thread.study.chapter4.getQueueLengthTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-20 23:40
 */
public class Run {

    public static void main(String[] args) throws Exception {


        final Service service = new Service();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod1();
            }
        };


        Thread[] threadArray = new Thread[50];

        for (int i = 0; i < 50; i++) {
            threadArray[i] = new Thread(runnable);

        }


        for (int i = 0; i < 50; i++) {
            threadArray[i].start();
        }
        Thread.sleep(50);
        System.out.println(" 有线程数：" + service.lock.getQueueLength() + "在等待获取锁。。");


    }


}
