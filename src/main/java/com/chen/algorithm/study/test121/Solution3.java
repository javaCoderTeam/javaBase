package com.chen.algorithm.study.test121;

import org.junit.Test;

/**
 * 双指针算法
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
 *
 * @author :  chen weijie
 * @Date: 2019-11-01 23:54
 */
public class Solution3 {


    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            max = Math.max(max, price - min);
        }
        return max;
    }


    @Test
    public void testCase() {

        int[] n = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(n));
    }

}
