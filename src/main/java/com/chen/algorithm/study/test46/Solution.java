package com.chen.algorithm.study.test46;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 题解都没看懂
 * <p>
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 19:23
 */
public class Solution {


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> nums_lst = new ArrayList<>();

        for (int num : nums) {
            nums_lst.add(num);
        }

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;

    }

    public void backtrack(int n, ArrayList<Integer> nums_lst,
                          List<List<Integer>> output,
                          int first) {

        if (first == n) {
            output.add(new ArrayList<>(nums_lst));
            return;
        }

        for (int i = first; i < n; i++) {
            Collections.swap(nums_lst, first, i);
            backtrack(n, nums_lst, output, first + 1);
            Collections.swap(nums_lst, first, i);
        }
    }


    @Test
    public void testCase() {

        int[] ints = {1, 2, 3};

        System.out.println(JSONObject.toJSONString(permute(ints)));


    }


}
