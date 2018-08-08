package com.chen.api.util.thread.test1;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class ThreadMain {


    public static void main(String[] args) {

        SpeakHello speakHello = new SpeakHello();
        SpeakNiHao speakNiHao = new SpeakNiHao();
        speakHello.start();
        speakNiHao.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("我是主程序" + i);
        }


    }

}
