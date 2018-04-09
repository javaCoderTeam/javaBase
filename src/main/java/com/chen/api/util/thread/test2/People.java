package com.chen.api.util.thread.test2;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class People extends Thread {

    StringBuffer stringBuffer;

    People(String name,StringBuffer stringBuffer){
        setName(name);
        this.stringBuffer =stringBuffer;
    }


    public void run(){
        for (int i =0;i<10;i++){
            stringBuffer.append(getName()+",");
            System.out.println("我是"+getName()+",字符串是："+stringBuffer.toString());

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
