package com.chen.api.util.thread.study.chapter2.syn_out_asyn;

import java.util.List;

/**
 * @author chen weijie
 * @date 2018-04-16 12:32 AM
 */
public class ThreadB extends Thread {

    private  MyList myList;

    public ThreadB(MyList myList) {
        super();
        this.myList = myList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            myList.add("threadB" + (i + 1));
        }
    }

}
