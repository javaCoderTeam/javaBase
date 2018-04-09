package com.chen.api.util.thread.study.chapter1.notSafeThread;

/**
 * A 线程
 *
 * @author Chen WeiJie
 * @date 2018-04-09 16:15
 **/
public class ALogin extends Thread {

    @Override
    public void run() {
        NotSafeThreadServlet.doPost("a", "aaaaaa");
    }

}
