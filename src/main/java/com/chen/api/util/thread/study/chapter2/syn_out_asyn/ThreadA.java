package com.chen.api.util.thread.study.chapter2.syn_out_asyn;

import java.util.List;

/**
 * @author chen weijie
 * @date 2018-04-16 12:32 AM
 */
public class ThreadA extends Thread {

    private MyList myList;

    public ThreadA(MyList myList) {
        super();
        this.myList = myList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            myList.add("threadA" + (i + 1));
        }
    }

}
