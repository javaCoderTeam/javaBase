package com.chen.algorithm.study.test136;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-02 00:36
 */
public class Solution {


    public int singleNumber(int[] nums) {

        int ans = 0;
        for(int num: nums) {
            ans ^= num;
        }
        return ans;

    }

    @Test
    public void testCase() {

        int[] n = {4, 3, 4, 3, 1};

        System.out.println(singleNumber(n));
    }

}
