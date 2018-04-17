package com.chen.api.util.thread.study.chapter2.twoStop;

/**
 * @author chen weijie
 * @date 2018-04-17 11:56 PM
 */
public class Service {


    synchronized public void methodA() {
        System.out.println("methodA begin..");

        boolean isContinueRun = true;

        while (isContinueRun) {

        }

        System.out.println("methodA end");
    }

    synchronized public void methodB() {
        System.out.println("methodB begin");
        System.out.println("methodB end");
    }


}
