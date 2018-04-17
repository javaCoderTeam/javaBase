package com.chen.api.util.thread.study.chapter2.StringAndSyn;

/**
 * @author chen weijie
 * @date 2018-04-17 11:43 PM
 */
public class ThreadB extends Thread {


    private String param;

    public ThreadB(String param) {
        super();
        this.param = param;
    }

    @Override
    public void run() {
        super.run();
        Service.print(param);
    }


}
