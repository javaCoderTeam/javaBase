package com.chen.api.util.thread.study.chapter3.threadLocalTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-16 00:47
 */
public class ThreadA extends Thread {



    @Override
    public void run(){
        try {
            for (int i = 0; i < 100; i++) {
                Tools.t1.set("ThradA :" + (i + 1));
                System.out.println("ThreadA get value:" + Tools.t1.get());
                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
