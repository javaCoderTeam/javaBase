package com.chen.algorithm.znn.backtrack.test90;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/solution/hui-su-suan-fa-by-powcai-5/
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 19:41
 * @Description: 子集 II
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //排序
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> curList, List<List<Integer>> res) {
        res.add(new ArrayList<>(curList));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            backtrack(i + 1, nums, curList, res);
            curList.remove(curList.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
