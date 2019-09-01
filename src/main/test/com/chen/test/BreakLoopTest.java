package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2019-08-30 11:17
 */
public class BreakLoopTest {


    public static void main(String[] args) {

//        loop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    System.out.println("i===="+i);
//                    break loop;
//                    continue;

                    break;
                }
                System.out.println(i);
            }
        }

        System.out.println(123);
    }

}
