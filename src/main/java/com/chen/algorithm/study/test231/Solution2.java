package com.chen.algorithm.study.test231;

/**
 * @author :  chen weijie
 * @Date: 2020-05-17 17:45
 */
public class Solution2 {

    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }

        return (n & (n - 1)) == 0;

    }
}
