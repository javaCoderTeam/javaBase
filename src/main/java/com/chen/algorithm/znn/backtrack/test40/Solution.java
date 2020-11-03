package com.chen.algorithm.znn.backtrack.test40;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
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
