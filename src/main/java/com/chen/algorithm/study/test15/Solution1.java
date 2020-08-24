package com.chen.algorithm.study.test15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2020-05-04 10:46
 */
public class Solution1 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                int sum = nums[left] + nums[right] + nums[i];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }


        return res;
    }


}
