package com.chen.api.util.thread.study.chapter2.t5;

/**
 * synchronized修饰方法所导致的运行任务花很长的时间
 *
 * @author chen weijie
 * @date 2018-04-14 6:35 PM
 */
public class Task {

    private String getData1;

    private String getData2;

    synchronized public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程的返回值1 ThreadName=" + Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程的返回值2 ThreadName=" + Thread.currentThread().getName();

            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
