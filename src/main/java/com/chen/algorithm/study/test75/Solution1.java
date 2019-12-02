package com.chen.algorithm.study.test75;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-20 01:00
 */
public class Solution1 {

    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }


        int temp;
        for (int i = 1; i <= nums.length - 1; i++) {

            int leftIndex = i - 1;
            temp = nums[i];

            while (leftIndex >= 0 && temp < nums[leftIndex]) {
                nums[leftIndex + 1] = nums[leftIndex];
                leftIndex--;
            }
            nums[leftIndex + 1] = temp;
        }
    }

    @Test
    public void testCase() {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(JSONObject.toJSONString(nums));


    }


}
