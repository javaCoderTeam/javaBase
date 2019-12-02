package com.chen.algorithm.study.test121;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-01 23:54
 */
public class Solution {


    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = prices.length - 1; j > 0; j--) {
                if (i > j) {
                    continue;
                }
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }


    @Test
    public void testCase() {

        int[] n = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(n));
    }

}
