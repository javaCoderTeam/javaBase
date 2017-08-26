package com.chen.other;

/**
 * Created by chenwj3 on 2017/2/20.
 */
public class LoopTest {

    public static void main(String args[]) {

        complexLoop();
    }


    public static void complexLoop() {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100000000; j++) {
                new String();
            }
        }
        long after = System.currentTimeMillis();
        System.out.println("小嵌大循环耗时:" + (after - before) + "ms");

        long before2 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            for (int j = 0; j < 10; j++) {
                new String();
            }
        }
        long after2 = System.currentTimeMillis();
        System.out.println("大嵌小循环耗时:" + (after2 - before2) + "ms");
    }

}
