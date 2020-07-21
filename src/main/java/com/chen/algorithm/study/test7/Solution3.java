package com.chen.algorithm.study.test7;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-04 01:51
 */
public class Solution3 {

    public int reverse(int x) {


        int rev = 0;
        while (x != 0) {

            int pop = x % 10;
//            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)){
//                return 0;
//            }
//
//            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)){
//                return 0;
//            }

            x = x / 10;
            rev = pop + 10 * rev;
        }


        return rev;
    }


    @Test
    public void testCase() {

        System.out.println(reverse(120));

    }

}
