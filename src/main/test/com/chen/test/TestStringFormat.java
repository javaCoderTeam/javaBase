package com.chen.test;

/**
 * @author chen weijie
 * @date 2018-03-27 12:07 AM
 */
public class TestStringFormat {

    public static void main(String[] args) {

        String index = String.format("%02d", 1 % 10);
        String index1 = String.format("%02d", 2 % 10);
        String index2 = String.format("%02d", 10 % 10);
        String index3 = String.format("%02d", 10000 % 10);
        String index4 = String.format("%02d", 6 % 10);
        String index5 = String.format("%02d", 9 % 10);
        System.out.println(index);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
        System.out.println(index5);

    }

}
