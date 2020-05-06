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

        if (nums == null || nums.length < 3) {
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

            int L = i + 1, R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L<R && nums[L] == nums[L+1]) {
                        L++; // 去重
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                }else if (sum<0){
                    L++;
                }else {
                    R--;
                }
            }
        }
        return res;
    }


}
