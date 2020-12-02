package com.chen.algorithm.znn.divide.test50;

import org.junit.Test;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * @Auther: zhunn
 * @Date: 2020/11/2 16:13
 * @Description: Pow(x, n)：1-递归；2-迭代（推荐）
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
        System.out.println(myPow(2.0, 10));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double res = 1d;
        double x_con = x;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * x_con;
            }
            x_con = x_con * x_con;
            n = n / 2;
        }
        return res;
    }
}
