package com.chen.algorithm.znn.hash.test18;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zhunn
 * @Date: 2020/10/26 15:09
 * @Description: 四数之和：类比三数之和方法
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int L = j + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        L++;
                        R--;
                    } else if (sum < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> ans = fourSum(nums, 0);
        System.out.println(JSON.toJSONString(ans));
    }
}
