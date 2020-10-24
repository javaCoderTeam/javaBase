package com.chen.algorithm.znn.array.test581;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
 *
 * @author: zhunn
 * @Date: 2020-10-07 23:34
 * @Description: 最短无序连续子数组
 */
public class Solution {


    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }


    @Test
    public void testCase() {


        int[] n = {2, 6, 4, 8, 10, 9, 15};

        System.out.println(findUnsortedSubarray(n));


    }


}