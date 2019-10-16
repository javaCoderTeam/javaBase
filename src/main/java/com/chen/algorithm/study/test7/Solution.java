package com.chen.algorithm.study.test7;

import org.junit.Test;

/**
 * low
 * @author :  chen weijie
 * @Date: 2019-09-04 01:17
 */
public class Solution {

    public int reverse(int x) {

        boolean belowZero = false;
        Long l = Long.parseLong(x + "");
        if (l < 0) {
            l = Math.abs(l);
            belowZero = true;
        }

        char[] chars = (l + "").toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        Long result = Long.parseLong(sb.toString());
        if (result > 2147483647 || result <-2147483648) {
            return 0;
        }

        if (!belowZero) {
            return result.intValue();
        } else {
            return -result.intValue();
        }

    }


    @Test
    public void testCase() {
        //   -2147483648~2147483647
        System.out.println(reverse(-2143847412));

    }


}
