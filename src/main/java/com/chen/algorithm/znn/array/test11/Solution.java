package com.chen.algorithm.znn.array.test11;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 盛最多水的容器：双指针法
 */
public class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
