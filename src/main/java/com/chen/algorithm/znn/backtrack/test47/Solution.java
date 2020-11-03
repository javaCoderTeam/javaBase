package com.chen.algorithm.znn.backtrack.test47;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * @Auther: zhunn
 * @Date: 2020/11/3 19:39
 * @Description: 全排列 II
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, used, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, List<Integer> curList, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            curList.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, curList, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            curList.remove(curList.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 1, 2};
        System.out.println(JSONObject.toJSONString(permuteUnique(nums)));
    }
}
