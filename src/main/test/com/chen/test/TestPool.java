package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2020-06-06 16:40
 */
public class TestPool {


    public static void main(String[] args) {

        System.out.println(count(10));
    }


    public static int count(int i) {
        int c = i + i;
        return count(c);
    }


}
