package com.chen.algorithm.study.test46;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 题解都没看懂
 * <p>
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 19:23
 */
public class Solution1 {


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(output, used, new ArrayList<>(), nums);
        return output;

    }

    public void backtrack(List<List<Integer>> output, boolean[] used, List<Integer> current, int[] nums) {

        if (current.size() == nums.length) {
            output.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                backtrack(output, used, current, nums);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }


    @Test
    public void testCase() {

        int[] ints = {1, 2, 3};

        System.out.println(JSONObject.toJSONString(permute(ints)));


    }


}
