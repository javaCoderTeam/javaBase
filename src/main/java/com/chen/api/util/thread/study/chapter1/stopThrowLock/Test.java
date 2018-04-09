package com.chen.api.util.thread.study.chapter1.stopThrowLock;

/**
 * @author chen weijie
 * @date 2018-04-10 1:19 AM
 */
public class Test {

    public static void main(String[] args) {

        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread myThread = new MyThread(object);
            myThread.start();
            Thread.sleep(500);
            myThread.stop();
            System.out.println(object.getUserName() + "----------" + object.getPassWord());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
