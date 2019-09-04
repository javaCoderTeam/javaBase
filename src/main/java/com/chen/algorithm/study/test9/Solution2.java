package com.chen.algorithm.study.test9;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-04 23:09
 */
public class Solution2 {


//    通过计算 1221 / 1000， 得首位1
//    通过计算 1221 % 10， 可得末位 1

    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) {
            return false;
        }

        int div = 1;
        //
        while (x / div >= 10) {
            div *= 10;
        }

        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }


    @Test
    public void testCase() {
        System.out.println(isPalindrome(121));
    }

}
