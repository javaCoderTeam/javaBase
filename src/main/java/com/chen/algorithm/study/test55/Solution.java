package com.chen.algorithm.study.test55;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/jump-game/solution/dong-tai-gui-hua-yu-tan-xin-suan-fa-jie-jue-ci-wen/
 *
 *
 * 我们记录一个的坐标代表当前可达的最后节点，这个坐标初始等于nums.length-1，
 * 然后我们每判断完是否可达，都向前移动这个坐标，直到遍历结束。
 *
 * 如果这个坐标等于0，那么认为可达，否则不可达。
 *
 * @author :  chen weijie
 * @Date: 2019-11-13 00:26
 */
public class Solution {

    public boolean canJump(int[] nums) {


        if (nums == null) {
            return false;
        }

        int lastPosition = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            // 逐步向前递推
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }

        return lastPosition == 0;
    }


    @Test
    public void testCase() {

        int[] n = {3, 2, 1, 1, 4};

        System.out.println(canJump(n));

    }


}
