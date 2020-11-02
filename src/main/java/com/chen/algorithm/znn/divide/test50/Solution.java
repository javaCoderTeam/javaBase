package com.chen.algorithm.znn.divide.test50;

import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/11/2 16:13
 * @Description: Pow(x, n)：1-递归；2-迭代
 */
public class Solution {

    /**
     * 1-递归
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }
        int N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        return quick(x, N);
    }

    private double quick(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }
        double y = quick(x, n / 2);
        return n % 2 == 1 ? y * y * x : y * y;
    }

    /**
     * 2-迭代
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1d;
        }

        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double res = 1d;
        double x_contribute = x;
        while (N > 0) {
            if (N % 2 == 1) {
                res = res * x_contribute;
            }
            x_contribute = x_contribute * x_contribute;
            N = N / 2;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(myPow2(2.0, 5));
    }
}
