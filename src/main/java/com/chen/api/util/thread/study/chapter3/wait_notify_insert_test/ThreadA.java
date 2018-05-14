package com.chen.api.util.thread.study.chapter3.wait_notify_insert_test;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 00:46
 */
public class ThreadA  extends Thread{


    private DBTooles dbTooles;

    public ThreadA(DBTooles dbTooles){
        this.dbTooles =dbTooles;
    }

    @Override
    public void run(){
        dbTooles.backupA();
    }



}
