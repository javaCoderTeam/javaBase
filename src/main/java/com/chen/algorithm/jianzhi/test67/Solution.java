package com.chen.algorithm.jianzhi.test67;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-09-12 19:02
 */
public class Solution {


    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            if (res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;

    }


    @Test
    public void testCase() {

        String str = "2147483646";
        System.out.println(strToInt(str));
    }

}
