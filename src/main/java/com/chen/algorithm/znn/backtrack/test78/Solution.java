package com.chen.algorithm.znn.backtrack.test78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/solution/hui-su-suan-fa-by-powcai-5/
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 19:23
 * @Description: 子集
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> curList, List<List<Integer>> res) {
        res.add(new ArrayList<>(curList));
        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            backtrack(i + 1, nums, curList, res);
            curList.remove(curList.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] n = {1, 2, 3};
        System.out.println(subsets(n));


    }
}
