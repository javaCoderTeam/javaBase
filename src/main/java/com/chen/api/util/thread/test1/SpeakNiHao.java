package com.chen.api.util.thread.test1;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class SpeakNiHao extends Thread {

    public void run() {

        for (int i = 0; i < 20; i++) {
            System.out.println("你好" + i);
        }


    }

}
