package com.chen.api.util.thread.threadPool;

/**
 * User: chenweijie
 * Date: 10/17/17
 * Time: 11:51 PM
 * Description: 线程池相关
 * http://www.cnblogs.com/aspirant/p/6920418.html
 */
public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "正在运行。。。");
    }

}
