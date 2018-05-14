package com.chen.api.util.thread.study.chapter3.wait_notify_insert_test;

/**
 * db测试工具类
 *
 * @author :  chen weijie
 * @Date: 2018-05-15 00:40
 */
public class DBTooles {


    volatile private boolean prevIsA = false;

    synchronized public void backupA() {

        try {
            while (prevIsA) {
                wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("AAAAAAAAAAAAAA");
            }

            prevIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    synchronized public void backupB() {

        try {
            while (!prevIsA) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("BBBBBBBBBBBBBBBBBB");
            }
            prevIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
