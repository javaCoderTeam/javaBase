package com.chen.api.util.thread.print;

import org.junit.Test;

import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2020-06-30 19:49
 */
public class PrintAB {
    /*
        1. 任务：两个线程交替的打印从1到100里面的奇数和偶数
        2. 但是你如果查看打印结果会发现，其实当第一个线程运行的时候
            另一个线程也没有闲着，也会在else里面打印，只是没有进入到它的if里面
        3. 这样的方式可以满足交替打印的目的，但是效率不是很高，不推荐，我们再去尝试一下其它的方式
        4. volatile 是必须要加的

     */

    public static int i = 1;

    public static volatile boolean flag = false;

    public static void test1() {
        new Thread(() -> {
            while (i <= 100) {
                if (flag == false) {
                    System.out.println(Thread.currentThread().getName() + i);
                    i++;
                    flag = true;
                }else {
//                    System.out.println("奇"+i);
                }
            }
        }, "奇数线程：").start();

        new Thread(() -> {
            while (i <= 100) {
                if (flag == true) {
                    System.out.println(Thread.currentThread().getName() + i);
                    i++;
                    flag = false;
                }else {
//                    System.out.println("偶"+i);
                }
            }
        }, "偶数线程：").start();


    }

    @Test
    public void test1_1(){
        test1();
    }






}
