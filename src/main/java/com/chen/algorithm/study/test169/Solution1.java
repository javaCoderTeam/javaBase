package com.chen.algorithm.study.test169;

import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
 * 
 * @author :  chen weijie
 * @Date: 2019-11-02 18:24
 */
public class Solution1 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
