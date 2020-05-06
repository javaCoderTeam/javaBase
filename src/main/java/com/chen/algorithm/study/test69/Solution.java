package com.chen.algorithm.study.test69;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-03 09:39
 */
public class Solution {


    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 2, right = x / 2, pivot;
        long result;

        while (right >= left) {
            pivot = (right - left) / 2 + left;
            result = (long) pivot * pivot;
            if (result > x) {
                right = pivot - 1;
            } else if (result < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }
        return right;
    }

    @Test
    public void test() {
        System.out.println(mySqrt(8));
    }

}
