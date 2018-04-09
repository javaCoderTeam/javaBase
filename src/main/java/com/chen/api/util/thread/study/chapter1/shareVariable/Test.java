package com.chen.api.util.thread.study.chapter1.shareVariable;

import com.chen.api.util.thread.study.chapter1.notShareVariable.MyThread;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-09 3:18 AM
 */
public class Test {

    public static void main(String[] args) {

        //thread实例其实和Runnable代码块一样,可以使用new Thread(thread) 创建线程;
        ShareVariableThread thread = new ShareVariableThread();
        Thread t1 = new Thread(thread, "t1");
        Thread t2 = new Thread(thread, "t2");
        Thread t3 = new Thread(thread, "t3");
        Thread t4 = new Thread(thread, "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

//        打印的结果其实时重复的,是非线程安全的
//        t3计算,count=9
//        t2计算,count=8
//        t1计算,count=9
//        t4计算,count=7

        //在代码块中加synchronize同步锁,使得代码按照顺序执行
        ShareVariableThread2 thread2 =new ShareVariableThread2();
        Thread t5 =new Thread(thread2,"t5");
        Thread t6 =new Thread(thread2,"t6");
        Thread t7 =new Thread(thread2,"t7");
        Thread t8 =new Thread(thread2,"t8");
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        //在执行run方法前,先判断方法是否加synchronize锁,如果上锁,说明其它线程在调用run方法,必须等待其它线程对run方法调用结束后才可以执行run方法


    }
}
