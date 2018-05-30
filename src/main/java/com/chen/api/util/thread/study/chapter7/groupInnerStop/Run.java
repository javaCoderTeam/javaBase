package com.chen.api.util.thread.study.chapter7.groupInnerStop;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 00:50
 */
public class Run {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("我的线程组");

        try {
            for (int i = 0; i < 10; i++) {
                MyThread thread = new MyThread(threadGroup, "线层：" + i);
                thread.start();
            }
            Thread.sleep(5000);
            threadGroup.interrupt();
            System.out.println("调用了interrupt方法。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
