package com.chen.algorithm.znn.array.test581;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * @author: zhunn
 * @Date: 2020-10-07 23:34
 * @Description: 最短无序连续子数组：排序对比原数组
 */
public class Solution {


    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;

        for (int i = 0; i < snums.length; i++) {
            if (snums[i] == nums[i]) {
                continue;
            }
            start = Math.min(start, i);
            end = Math.max(end, i);
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    public int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length == 0) {
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
        return (end - start) < 0 ? 0 : end - start + 1;
    }

    @Test
    public void testCase() {
        int[] n = {2, 6, 4, 8, 10, 9, 15};

        System.out.println(findUnsortedSubarray(n));
        System.out.println(findUnsortedSubarray2(n));
    }


}
