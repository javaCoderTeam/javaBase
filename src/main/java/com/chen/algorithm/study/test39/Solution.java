package com.chen.algorithm.study.test39;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 不会。。。
 *
 * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 18:40
 */
public class Solution {


    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int len = candidates.length;
        if (len == 0) {
            return res;
        }

        this.candidates = candidates;
        this.len = len;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }


    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue < 0) {
            return;
        }

        if (residue == 0) {
            res.add(new ArrayList<>(pre));
        }

        for (int i = start; i < len; i++) {
            pre.add(candidates[i]);
            findCombinationSum(residue - candidates[i], i, pre);
            pre.pop();
        }
    }

    @Test
    public void testCase() {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;


        System.out.println(JSONObject.toJSONString(combinationSum(candidates, target)));


    }


}
