package com.chen.algorithm.znn.bitmap.test338;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
 *
 * @Auther: zhunn
 * @Date: 2020/11/07 22:23
 * @Description: 比特位计数：1-位运算-Pop count；2-动态规划+最后设置位；3-动态规划+最高有效位；4-动态规划+最低有效位；
 */
public class Solution {

    /**
     * 1-位运算-Pop count
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = popCount(i);
        }
        return res;
    }

    private int popCount(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 2-动态规划+最后设置位
     *
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(countBits(2)));
        System.out.println(JSON.toJSONString(countBits2(5)));
    }
}
