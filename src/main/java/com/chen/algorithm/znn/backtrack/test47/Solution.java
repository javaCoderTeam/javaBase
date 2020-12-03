package com.chen.algorithm.znn.backtrack.test47;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
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
        backtrack(0, nums.length, nums, used, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int depth, int len, int[] nums, boolean[] used, List<Integer> curList, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < len; i++) {
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
            backtrack(depth + 1, len, nums, used, curList, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            curList.remove(curList.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 1, 2};
        System.out.println(JSONObject.toJSONString(permuteUnique(nums)));
        System.out.println(JSONObject.toJSONString(permuteUnique2(nums)));
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(0, nums.length, nums, used, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int depth, int len, int[] nums, boolean[] used, List<Integer> curList, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            curList.add(nums[i]);
            dfs(depth + 1, len, nums, used, curList, res);
            curList.remove(curList.size() - 1);
            used[i] = false;
        }
    }
}
