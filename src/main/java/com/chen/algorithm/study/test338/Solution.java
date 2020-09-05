package com.chen.algorithm.study.test338;

/**
 * @author :  chen weijie
 * @Date: 2020-09-02 02:11
 */
public class Solution {

    public int[] countBits(int num) {

        int[] nums = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            nums[i] = countBit(i);
        }
        return nums;
    }


    public int countBit(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
