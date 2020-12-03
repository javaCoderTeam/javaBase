package com.chen.algorithm.znn.backtrack.test39;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 15:27
 * @Description: 组合总和
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        // 排序是剪枝的前提
        //Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int target, int[] candidates, List<Integer> curList, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            curList.add(candidates[i]);
            //System.out.println("递归之前 => " + curList + "，剩余 = " + (target - candidates[i]));
            backtrack(i, target - candidates[i], candidates, curList, res);
            curList.remove(curList.size() - 1);
            //System.out.println("递归之后 => " + curList);
        }
    }
    //private void backtrack(int start, int target, int[] candidates, List<Integer> curList, List<List<Integer>> res) {
    //    // 由于进入更深层的时候，小于0的部分被剪枝，因此递归终止条件值只判断等于0的情况
    //    //if (target < 0) {
    //    //    return;
    //    //}
    //    if (target == 0) {
    //        res.add(new ArrayList<>(curList));
    //        return;
    //    }
    //    // 重点理解这里从start开始搜索的语意
    //    for (int i = start; i < candidates.length; i++) {
    //        if (candidates[i] > target) { // 重点理解这里剪枝，前提是候选数组已经有序
    //            continue;
    //        }
    //        curList.add(candidates[i]);
    //        backtrack(i, target - candidates[i], candidates, curList, res);// 注意每个元素可以重复使用，下一轮搜索的起点依然是 i
    //        curList.remove(curList.size() - 1); //状态重置
    //    }
    //}

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(JSONObject.toJSONString(combinationSum(candidates, target)));
    }
}
