package com.chen.api.util.thread.study.chapter2.syn_out_asyn;

import com.chen.api.util.thread.study.chapter2.synBlockingString2.ThreadA;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen weijie
 * @date 2018-04-16 12:27 AM
 */
public class MyList {

    private List list = new ArrayList();

    synchronized public void add(String userName) {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "执行了add方法!");
        list.add(userName);
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "退出了add方法!");
    }

    synchronized public int getSize() {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "执行了getSize方法!");
        int sizeValue = list.size();
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "退出了getSize方法!");
        return sizeValue;
    }


}
