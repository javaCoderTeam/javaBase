package com.chen.api.util.thread.study.chapter3.join_test;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 01:04
 */
public class Run {


    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    int secondValue = (int)(Math.random() * 10000);
                    System.out.println(secondValue);

                    Thread.sleep(secondValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("我想在thread方法执行完毕后执行，但是sleep多少秒呢？");
        System.out.println("答案是不能确定！！");
    }

}
