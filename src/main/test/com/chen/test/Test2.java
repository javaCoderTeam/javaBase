package com.chen.test;

import java.util.Date;

/**
 * @author Chen WeiJie
 * @date 2020-04-27 15:22:48
 **/
public class Test2 {


    public static void main(String[] args) {

        Date d = new Date();

        Date d2 = d;

        System.out.println(d.compareTo(d2));




    }
}
