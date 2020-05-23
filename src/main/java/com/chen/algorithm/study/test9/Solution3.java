package com.chen.algorithm.study.test9;

/**
 * @author :  chen weijie
 * @Date: 2020-05-19 12:16
 */
public class Solution3 {


    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int m = x;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            rev = rev * 10 + pop;
        }

        return rev == m;
    }

}
