package com.chen.api.util.thread.study.chapter2.StringAndSyn;

/**
 * @author chen weijie
 * @date 2018-04-17 11:43 PM
 */
public class ThreadA extends Thread {


    private String param;

    public ThreadA(String param) {
        super();
        this.param = param;
    }

    @Override
    public void run() {
        super.run();
        Service.print(param);
    }


}
