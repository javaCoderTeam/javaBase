package com.chen.algorithm.study.test75;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-20 00:51
 */
public class Solution {


    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }


        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j <= nums.length - 1; j++) {
                int temp;
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


    @Test
    public void testCase() {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(JSONObject.toJSONString(nums));


    }


}
