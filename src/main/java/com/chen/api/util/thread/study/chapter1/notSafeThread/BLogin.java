package com.chen.api.util.thread.study.chapter1.notSafeThread;

/**
 * B线程
 *
 * @author Chen WeiJie
 * @date 2018-04-09 16:16
 **/
public class BLogin extends Thread {

    @Override
    public void run() {
        NotSafeThreadServlet.doPost("b", "bbbbbbbb");
    }

}
