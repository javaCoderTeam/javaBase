package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2019-07-17 20:24
 */
public class BreakLoop {


    public static void main(String[] args) {



        loop:
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.println("i==="+i+",j=="+j);
                if (i==2){
                    break loop;
                }

            }
        }

        System.out.println(123);



    }



}
