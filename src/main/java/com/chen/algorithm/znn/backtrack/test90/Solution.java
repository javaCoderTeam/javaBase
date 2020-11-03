package com.chen.algorithm.znn.backtrack.test90;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/solution/hui-su-suan-fa-by-powcai-5/
 * @Auther: zhunn
 * @Date: 2020/11/3 19:41
 * @Description: 子集 II
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //排序
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, ArrayList<Integer> curList, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curList));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            backtrack(nums, i + 1, curList, ans);
            curList.remove(curList.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
