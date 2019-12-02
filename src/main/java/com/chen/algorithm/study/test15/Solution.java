package com.chen.algorithm.study.test15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 *
 * @author :  chen weijie
 * @Date: 2019-11-08 23:46
 */
public class Solution {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        int len = nums.length;
        if (len < 3) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return ans;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
            }
        }
        return ans;
    }


}
