package com.chen.api.util.thread.study.chapter3.test2;

/**
 * @author :  chen weijie
 * @Date: 2018-04-24 00:11
 */
public class Test {

    public static void main(String[] args) {

        String lock =new String("b");
        System.out.println("syn 上面");
        synchronized (lock){
            System.out.println("syn第一行");
            try {
                lock.wait();
                System.out.println("sync wait下的代码");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("syn下面的代码");
    }

}
