package com.chen.algorithm.study.test581;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
 *
 * @author :  chen weijie
 * @Date: 2019-11-07 23:34
 */
public class Solution1 {


    public int findUnsortedSubarray(int[] nums) {

        int l = nums.length, r = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }

        return r - l < 0 ? 0 : r - l + 1;
    }


    @Test
    public void testCase() {


        int[] n = {2, 6, 4, 8, 10, 9, 15};

        System.out.println(findUnsortedSubarray(n));


    }


}
