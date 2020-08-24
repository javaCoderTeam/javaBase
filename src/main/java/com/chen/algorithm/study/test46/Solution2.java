package com.chen.algorithm.study.test46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 *
 *
 * 回溯算法的框架：
 *
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 *
 * @author :  chen weijie
 * @Date: 2020-08-05 15:38
 */
public class Solution2 {


    public List<List<Integer>> permute(int[] array) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[array.length];
        backtrack(array, 0, array.length, res, new ArrayList<>(), used);
        return res;
    }


    private void backtrack(int[] nums, int depth, int len, List<List<Integer>> res, List<Integer> path, boolean[] used) {

        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {

            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                backtrack(nums, depth + 1, len, res, path, used);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute(nums);
        System.out.println(lists);
    }


}
