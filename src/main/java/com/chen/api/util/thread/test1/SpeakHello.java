package com.chen.api.util.thread.test1;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class SpeakHello extends Thread {


    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Hello" + i);
        }

    }


}
