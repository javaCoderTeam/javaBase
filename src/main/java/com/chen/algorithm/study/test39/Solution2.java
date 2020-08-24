package com.chen.algorithm.study.test39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/combination-sum/solution/di-gui-hui-su-tu-wen-fen-xi-ji-bai-liao-9987de-yon/
 *
 * @author :  chen weijie
 * @Date: 2020-08-22 19:19
 */
public class Solution2 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] candidates, int target, List<Integer> curList, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(new Stack<>()));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //如果当前节点大于target我们就不要选了
            if (target < candidates[i]) {
                continue;
            }
            curList.add(candidates[i]);
            backtrack(res, candidates, (target - candidates[i]), curList, i);
            curList.remove(curList.size() - 1);
        }
    }

}
