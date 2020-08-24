package com.chen.algorithm.study.test231;

/**
 *
 * https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode/
 *
 * 如何获取二进制中最右边的 1：x & (-x)。
 * 如何将二进制中最右边的 1 设置为 0：x & (x - 1)。
 *
 *
 * 2 的幂二进制表示只含有一个 1。
 * x & (x - 1) 操作会将 2 的幂设置为 0，因此判断是否为 2 的幂是：判断 x & (x - 1) == 0。
 *
 *
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
