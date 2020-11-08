package com.chen.algorithm.znn.bitmap.test231;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode/
 *
 * @Auther: zhunn
 * @Date: 2020/11/07 22:23
 * @Description: 2的幂：1-位运算-获取二进制中最右边的 1（x&(-x)）；2-位运算-去除二进制中最右边的 1 （x&(x-1)）
 * 2 的幂二进制表示只含有一个 1。
 */
public class Solution {

    /**
     * 1-位运算-获取二进制中最右边的 1（x&(-x)）
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        long x = (long) n;
        return (x & (-x)) == x;
    }

    /**
     * 2-位运算-去除二进制中最右边的 1 （x&(x-1)）
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

    @Test
    public void test() {
        System.out.println(isPowerOfTwo(16));
    }
}
