package com.chen.algorithm.study.test39;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 不会。。。
 * <p>
 * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 18:40
 */
public class Solution1 {


    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinationSum(candidates, target, 0, currentList, res);
        return res;
    }


    private void findCombinationSum(int[] candidates, int target, int start, List<Integer> currentList, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(currentList));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (target < candidates[i]) {
                continue;
            }
            currentList.add(candidates[i]);
            findCombinationSum(candidates, target - candidates[i], i, currentList, res);
            currentList.remove(currentList.size() - 1);
        }
    }

    @Test
    public void testCase() {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;


        System.out.println(JSONObject.toJSONString(combinationSum(candidates, target)));


    }


}
