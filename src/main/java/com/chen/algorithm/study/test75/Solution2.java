package com.chen.algorithm.study.test75;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode/
 *
 * @author :  chen weijie
 * @Date: 2019-11-20 00:51
 */
public class Solution2 {


    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int p0 = 0, curr = 0;

        int p2 = nums.length - 1;

        int temp;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                temp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = temp;
            } else if (nums[curr] == 2) {
                temp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = temp;
            } else {
                curr++;
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
