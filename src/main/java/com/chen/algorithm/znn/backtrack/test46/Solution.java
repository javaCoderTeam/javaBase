package com.chen.algorithm.znn.backtrack.test46;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
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
