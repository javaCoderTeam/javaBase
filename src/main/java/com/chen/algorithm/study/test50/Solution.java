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
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1d;
        double contribute = x;

        while (N > 0) {
            if (N % 2 == 1) {
                result = result * contribute;
            }
            contribute = contribute * contribute;

            N = N / 2;
        }

        return result;

    }

}

