package com.chen.api.util.thread.study.chapter3.join_interrupt;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 01:32
 */
public class ThreadC extends Thread {

    private  ThreadB threadB;

    public ThreadC (ThreadB threadB){
        this.threadB =threadB;
    }


    @Override
    public void run(){
        threadB.interrupt();
    }

}
