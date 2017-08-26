package com.chen.api.util.thread.runnable;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class Bank implements Runnable {

    private int num;

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        while (true) {
            if ("one".equals(threadName)) {
                if (num <= 160) {
                    System.out.println(threadName + "进入死亡状态。");
                    return;
                }
                num = num + 10;
                System.out.println("我是线程：" + threadName + ", 现在的num是：" + num);
            }

            if ("two".equals(threadName)) {
                if (num <= 0) {
                    System.out.println(threadName + "进入死亡状态。");
                    return;
                }
                num = num - 100;
                System.out.println("我是线程：" + threadName + ", 现在的num是：" + num);
            }

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
