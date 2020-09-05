package com.chen.algorithm.study.test338;

/**
 * @author :  chen weijie
 * @Date: 2020-09-02 02:11
 */
public class Solution1 {

    public int[] countBits(int num) {

        int[] count = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            count[i] = count[i & (i - 1)] + 1;
        }
        return count;
    }


}
