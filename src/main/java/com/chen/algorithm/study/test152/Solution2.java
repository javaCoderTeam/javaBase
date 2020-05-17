package com.chen.algorithm.study.test152;

/**
 * @author :  chen weijie
 * @Date: 2020-05-18 00:12
 */
public class Solution2 {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int curMax = nums[0], curMin = nums[0], iMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(num, curMax * num);
            curMin = Math.min(num, curMin * num);
            iMax = Math.max(curMax, iMax);
        }
        return iMax;
    }

}
