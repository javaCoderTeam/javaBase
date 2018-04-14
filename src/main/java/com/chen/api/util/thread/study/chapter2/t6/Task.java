package com.chen.api.util.thread.study.chapter2.t6;

import com.chen.api.util.thread.study.chapter2.throwExceptionNoLock.ThreadB;

/**
 * synchronized同步代码块解决 同步方法的弊端,相比与同步方法,同步代码块将时间由6秒较少为3秒
 *
 * @author chen weijie
 * @date 2018-04-14 6:35 PM
 */
public class Task {

    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String privateGetData1 = "长时间处理任务后从远程的返回值1 ThreadName=" + Thread.currentThread().getName() + ",time===" + System.currentTimeMillis();
            String privateGetData2 = "长时间处理任务后从远程的返回值2 ThreadName=" + Thread.currentThread().getName() + ",time===" + System.currentTimeMillis();
            synchronized (this) {
                getData1 = privateGetData1;
                getData2 = privateGetData2;
                System.out.println(getData1);
                System.out.println(getData2);
            }
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
