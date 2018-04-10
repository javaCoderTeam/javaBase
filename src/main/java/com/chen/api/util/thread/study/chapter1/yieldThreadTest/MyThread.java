package com.chen.api.util.thread.study.chapter1.yieldThreadTest;

/**
 * yield是放弃cpu的使用时间,但是放弃的时间不确定,有可能放弃了又马上获取.
 *
 * @author chen weijie
 * @date 2018-04-11 12:43 AM
 */
public class MyThread {


    public static void main(String[] args) {


        Thread thread = new Thread() {
            @Override
            public void run() {


                long beginTime = System.currentTimeMillis();
                int count = 0;
                for (int i = 0; i < 300000000; i++) {
                    Thread.yield();
                    count = count + (i + 1);
                }

                long endTime = System.currentTimeMillis();

                System.out.println("用时:" + (endTime - beginTime));
            }
        };

        thread.start();

    }


}
