package com.chen.api.util.thread.study.chapter1.sleepThread;

/**
 * 休眠线程
 *
 * @author Chen WeiJie
 * @date 2018-04-09 20:53
 **/
public class SleepThreadTest extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("this thread name:" + this.currentThread().getName() + "....begin");
            System.out.println("start time:" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("end time:" + System.currentTimeMillis());
            System.out.println("this thread name：" + Thread.currentThread().getName() + "....end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
