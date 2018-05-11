package com.chen.api.util.thread.study.chapter3.stack1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen weijie
 * @date 2018-05-10 1:00 AM
 */
public class MyStack {

    private List list = new ArrayList();

    synchronized public void push() {
        try {
            if (list.size() == 1) {
                this.wait();
            }
            list.add("anyString=" + Math.random());
            this.notify();
            System.out.println("push==" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String returnValue = "";
        try {
            if (list.size() == 0) {
                System.out.println("pop中的线程呈什么状态," + Thread.currentThread().getName() + "线程呈wait状态.");
                this.wait();
            }

            returnValue = "" + list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop==" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }


}
