package com.chen.api.util.thread.study.chapter2.t5;

import com.chen.api.util.thread.study.chapter2.t6.CommonUtils;
import com.chen.api.util.thread.study.chapter2.t6.MyThread1;
import com.chen.api.util.thread.study.chapter2.t6.MyThread2;
import com.chen.api.util.thread.study.chapter2.t6.Task;

/**
 * @author chen weijie
 * @date 2018-04-14 6:47 PM
 */
public class TeskMain {

    public static void main(String[] args) {

        Task task = new Task();

        MyThread1 myThread1 = new MyThread1(task);
        MyThread2 myThread2 = new MyThread2(task);
        myThread1.start();
        myThread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long begin = Math.min(CommonUtils.beginTime1, CommonUtils.beginTime2);

        long end = Math.max(CommonUtils.endTime1, CommonUtils.endTime2);

        System.out.println("耗时:" + (end - begin));


    }

}
