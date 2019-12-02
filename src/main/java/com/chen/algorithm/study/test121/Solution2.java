package com.chen.algorithm.study.test121;

import org.junit.Test;

/**
 * 双指针算法
 *
 * @author :  chen weijie
 * @Date: 2019-11-01 23:54
 */
public class Solution2 {


    public int maxProfit(int[] prices) {


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
