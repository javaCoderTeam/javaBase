package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-29 18:08
 */
public class TestTask {


    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
           Thread thread = new Thread(new WorkTask(i));
            thread.start();
        }



    }


}
