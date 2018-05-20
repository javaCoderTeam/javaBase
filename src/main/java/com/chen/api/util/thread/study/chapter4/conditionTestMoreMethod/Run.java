package com.chen.api.util.thread.study.chapter4.conditionTestMoreMethod;

/**
 * @author :  chen weijie
 * @Date: 2018-05-17 00:17
 */
public class Run {

    public static void main(String[] args) {

        MyService service = new MyService();

        ThreadA threadA = new ThreadA(service);
        ThreadAA threadAA = new ThreadAA(service);

        threadA.setName("a");
        threadAA.setName("aa");

        ThreadB threadB = new ThreadB(service);
        ThreadBB threadBB = new ThreadBB(service);
        threadB.setName("b");
        threadBB.setName("bb");

        threadA.start();
        threadAA.start();
        threadB.start();
        threadBB.start();


    }


}
