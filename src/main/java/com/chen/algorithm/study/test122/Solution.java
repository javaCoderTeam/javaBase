package com.chen.algorithm.study.test122;

/**
 * @author :  chen weijie
 * @Date: 2020-05-16 23:36
 */
public class Solution {


    public static int maxProfit(int[] prices) {

        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max = max + (prices[i] - prices[i - 1]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] n = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(n));

    }


}
