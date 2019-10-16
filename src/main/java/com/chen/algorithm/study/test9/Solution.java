package com.chen.algorithm.study.test9;

import org.junit.Test;

/**
 * low
 * @author :  chen weijie
 * @Date: 2019-09-04 22:54
 */
public class Solution {


    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        char[] chars = String.valueOf(x).toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return x == Long.parseLong(sb.toString());
    }



    @Test
    public void testCase(){
        System.out.println(isPalindrome(2147483647));
    }


}
