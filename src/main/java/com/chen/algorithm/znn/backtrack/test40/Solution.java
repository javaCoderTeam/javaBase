package com.chen.algorithm.znn.backtrack.test40;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 15:28
 * @Description: 组合总和 II
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 排序是剪枝的前提
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, target, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int target, int[] nums, List<Integer> curList, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于0的部分被剪枝，因此递归终止条件值只判断等于0的情况
        //if (target < 0) {
        //    return;
        //}
        if (target == 0) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            curList.add(nums[i]);
            backtrack(i + 1, target - nums[i], nums, curList, res);
            curList.remove(curList.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> res = combinationSum2(nums, target);
        System.out.println(JSONObject.toJSONString(res));


    }
}
