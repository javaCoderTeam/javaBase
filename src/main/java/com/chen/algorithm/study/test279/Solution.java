package com.chen.algorithm.study.test279;

/**
 * @author :  chen weijie
 * @Date: 2019-12-22 15:13
 */
public class Solution {


    int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];

        return numSqu(n);

    }


    public int numSqu(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        int val = (int) Math.sqrt(n);
        if (val * val == n) {
            return memo[0] = 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            res = Math.min(res, numSqu(n - i * i) + 1);
        }

        return memo[n] = res;
    }

}
