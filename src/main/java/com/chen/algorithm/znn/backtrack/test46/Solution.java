package com.chen.algorithm.znn.backtrack.test46;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 * 回溯算法的框架：
 * result = []
 * def backtrack(路径, 选择列表):
 *    if 满足结束条件:
 *      result.add(路径)
 *      return
 *   for 选择 in 选择列表:
 *      做选择
 *      backtrack(路径, 选择列表)
 *      撤销选择
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 17:52
 * @Description: 全排列
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
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

            curList.add(nums[i]);
            used[i] = true;
            backtrack(depth + 1, len, nums, used, curList, res);
            // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
            curList.remove(curList.size() - 1);
            used[i] = false;
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 2, 3};
        System.out.println(JSONObject.toJSONString(permute(nums)));
    }
}
