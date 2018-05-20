package com.chen.api.util.thread.study.chapter4.useConditionWaitingNotifyOK;

/**
 * @author :  chen weijie
 * @Date: 2018-05-19 00:20
 */
public class Run {


    public static void main(String[] args) {

        try {
            MyService myService =new MyService();

            ThreadA threadA =new ThreadA(myService);
            threadA.setName("a");
            threadA.start();


            ThreadB threadB =new ThreadB(myService);
            threadB.setName("b");
            threadB.start();
            Thread.sleep(5000);

            myService.signalAll_A();
//            myService.signalAll_B();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
