package com.chen.algorithm.study.test50;

/**
 * 链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 * <p>
 * 递归
 *
 * @author :  chen weijie
 * @Date: 2020-05-16 22:50
 */
public class Solution {


    public double myPow(double x, int n) {

        long N = n;
        if (N > 0) {
            return quickMul(x, N);
        } else {
            return 1.0 / quickMul(x, -N);
        }
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1d;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}

