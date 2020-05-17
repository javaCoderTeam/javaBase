package com.chen.algorithm.study.test191;

/**
 * @author :  chen weijie
 * @Date: 2020-05-17 14:27
 */
public class Solution {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n &= (n - 1);
        }
        return result;
    }



}
