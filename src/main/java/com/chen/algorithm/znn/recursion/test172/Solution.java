package com.chen.algorithm.znn.recursion.test172;

import org.junit.Test;

/**
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 * @Auther: zhunn
 * @Date: 2020/11/2 10:43
 * @Description: 阶乘后的零的个数：1-递归；2-迭代
 */
public class Solution {

    /**
     * 1-递归 求阶乘
     *
     * @param n
     * @return
     */
    private int getFactorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    /**
     * 2-迭代 求阶乘
     *
     * @param n
     * @return
     */
    private int getFactorial2(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public int getZeroCount(int n) {
        int sum = getFactorial2(n);
        int count = 0;
        while (sum % 10 == 0) {
            count++;
            sum /= 10;
        }
        return count;
    }

    @Test
    public void test() {
        int res = getZeroCount(10);
        System.out.println(res);
    }
}
