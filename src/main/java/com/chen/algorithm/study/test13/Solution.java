package com.chen.algorithm.study.test13;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-04 23:18
 */
public class Solution {


    public int romanToInt(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Integer[] integers = new Integer[chars.length];

        for (int i = 0; i < chars.length; i++) {

            switch (chars[i]) {
                case 'I':
                    integers[i] = 1;
                    continue;
                case 'V':
                    integers[i] = 5;
                    continue;
                case 'X':
                    integers[i] = 10;
                    continue;
                case 'L':
                    integers[i] = 50;
                    continue;
                case 'C':
                    integers[i] = 100;
                    continue;
                case 'D':
                    integers[i] = 500;
                    continue;
                case 'M':
                    integers[i] = 1000;
                    continue;
                default:
            }
        }


        int firstValue = 0;
        int nextValue = 0;
        int sum = 0;


        for (int i = 0; i < integers.length; i++) {
            firstValue = integers[i];

            if (i == s.length() - 1) {
                sum += firstValue;
            } else {
                nextValue = integers[i + 1];
                if (firstValue >= nextValue) {
                    sum += firstValue;
                } else {
                    sum -= firstValue;
                }
            }


        }
        return sum;
    }


    @Test
    public void testCase() {
        System.out.println(romanToInt("IV"));
    }


}
