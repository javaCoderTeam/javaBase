package com.chen.algorithm.study.test191;

/**
 * @author :  chen weijie
 * @Date: 2020-05-17 14:27
 */
public class Solution1 {

    public int hammingWeight(int n) {

        int sum = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                sum++;
            }
            mask = mask << 1;
        }
        return sum;
    }


}
