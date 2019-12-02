package com.chen.algorithm.study.test78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-11-21 00:07
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }


    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {

        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    @Test
    public void testCase() {

        int[] n = {1, 2, 3};

        System.out.println(subsets(n));


    }


}
