package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2020-06-03 18:30
 */
public class TestCPUCount {


    public static void main(String[] args) {

        int n = Runtime.getRuntime().availableProcessors();
        System.out.println(n);

    }
}
