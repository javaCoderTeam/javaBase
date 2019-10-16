package com.chen.algorithm.study.test5;

import org.junit.Test;

/**
 * 中心扩展算法
 *
 * @author :  chen weijie
 * @Date: 2019-09-03 23:58
 */
public class Solution {


    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;


        for (int i = 0; i < s.length(); i++) {
            int len1 = expandArroundCenter(s, i, i);
            int len2 = expandArroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                //中间值-长度的一半
                start = i - (len - 1) / 2;
                //中间值+长度的一半
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    private int expandArroundCenter(String s, int left, int right) {

        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }



    @Test
    public void testCase(){
        System.out.println(longestPalindrome("dcacdefd"));
    }


}
