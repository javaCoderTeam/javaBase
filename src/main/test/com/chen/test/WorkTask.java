package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-29 18:06
 */
public class WorkTask implements Runnable {


    private int value;


    public WorkTask(int value) {
        this.value = value;
    }

    @Override
    public void run() {

        System.out.println(value);

    }
}
