package com.chen.algorithm.study.test69;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-03 09:39
 * @Description: zhunn x的平方根，舍弃小数
 */
public class Solution {


    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 1, right = x / 2, mid;
        long result;

        while (right >= left) {
            mid = (right - left) / 2 + left;
            result = (long) mid * mid;
            if (result > x) {
                right = mid - 1;
            } else if (result < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    @Test
    public void test() {
        System.out.println(mySqrt(2147395599));
    }

}
