package com.chen.algorithm.study.test40;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2020-09-18 17:21
 */
public class Solution {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrack(res, candidates, target, 0, new ArrayList<>());
        return res;

    }


    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int start, List<Integer> path) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }


        for (int i = start; i < candidates.length; i++) {

            if (target < candidates[i]) {
                break;
            }

            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(res, candidates, target - candidates[i], i + 1, path);
            path.remove(path.size() - 1);
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
