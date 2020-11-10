package com.chen.algorithm.znn.bitmap.test191;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
 * 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * @Auther: zhunn
 * @Date: 2020/11/07 21:23
 * @Description: 位1的个数：1-位运算；2-循环和位移动
 * 对于任意数字 n ，将 n 和 n−1 做与运算，会把最后一个 1 的位变成 0
 */
public class Solution {

    /**
     * 1-位运算
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1); // 将数字n最后一位1变为0
        }
        return sum;
    }

    public int hammingWeight2(int n) {

        int sum = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                sum++;
            }
            mask = mask << 1;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(-3));
    }
}
