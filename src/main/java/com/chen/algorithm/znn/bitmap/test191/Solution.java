package com.chen.algorithm.znn.bitmap.test191;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
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
