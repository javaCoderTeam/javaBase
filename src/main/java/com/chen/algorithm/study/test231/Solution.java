package com.chen.algorithm.study.test231;

/**
 * @author :  chen weijie
 * @Date: 2020-05-17 17:45
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
        }

        return n == 1;
    }
}
