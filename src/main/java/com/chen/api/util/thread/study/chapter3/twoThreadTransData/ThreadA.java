package com.chen.api.util.thread.study.chapter3.twoThreadTransData;

/**
 * @author chen weijie
 * @date 2018-04-23 12:14 AM
 */
public class ThreadA extends Thread {


    private MyList list;

    public ThreadA(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            list.add();
            System.out.println("list 添加了" + (i + 1) + "个元素");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
