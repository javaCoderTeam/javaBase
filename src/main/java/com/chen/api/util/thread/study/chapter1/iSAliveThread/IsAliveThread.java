package com.chen.api.util.thread.study.chapter1.iSAliveThread;

/**
 * 判断当前线程是否处于活跃状态,  this和currentThread方法的区别
 *
 * @author Chen WeiJie
 * @date 2018-04-09 18:41
 **/
public class IsAliveThread extends Thread {


    public IsAliveThread() {
        System.out.println("construct ------start");
        System.out.println("thread name:" + Thread.currentThread().getName());
        System.out.println("thread isAlive:" + Thread.currentThread().isAlive());
        System.out.println("this name:" + this.getName());
        System.out.println("this isAlive:" + this.isAlive());
        System.out.println("construct ------end");
    }

    @Override
    public void run() {
        System.out.println("run ------start");
        System.out.println("thread name:" + Thread.currentThread().getName());
        System.out.println("thread isAlive:" + Thread.currentThread().isAlive());
        System.out.println("this name:" + this.getName());
        System.out.println("this isAlive:" + this.isAlive());
        System.out.println("run ------end");
    }

}
