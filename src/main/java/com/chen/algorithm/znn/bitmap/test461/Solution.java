package com.chen.algorithm.znn.bitmap.test461;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/
 *
 * @Auther: zhunn
 * @Date: 2020/11/07 22:23
 * @Description: 汉明距离：1-内置位计数功能；2-移位；3-布赖恩·克尼根算法（x&(x-1)）
 */
public class Solution {

    /**
     * 1-内置位计数功能
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 2-移位
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {
        int dis = x ^ y;
        int res = 0;

        while (dis != 0) {
            if ((dis & 1) == 1) {
                res++;
            }
            dis = dis >> 1;
        }
        return res;
    }

    /**
     * 3-布赖恩·克尼根算法（x&(x-1)）
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance3(int x, int y) {
        int dis = x ^ y;
        int res = 0;
        while (dis != 0) {
            res++;
            dis = dis & (dis - 1);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance2(1, 4));
        System.out.println(hammingDistance3(1, 4));
    }
}
