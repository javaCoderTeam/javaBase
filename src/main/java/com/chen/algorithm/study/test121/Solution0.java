package com.chen.algorithm.study.test121;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-08-05 15:27
 */
public class Solution0 {


    public int max(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }


    @Test
    public void testCase() {
        int[] n = {4, 1, 6, 10, 3, 1, 18};
        System.out.println(max(n));
    }


}
