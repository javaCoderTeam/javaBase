package com.chen.algorithm.znn.bitmap.test461;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
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
