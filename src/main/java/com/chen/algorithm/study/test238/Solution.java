package com.chen.algorithm.study.test238;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/solution/cheng-ji-dang-qian-shu-zuo-bian-de-cheng-ji-dang-q/
 *
 * @author :  chen weijie
 * @Date: 2019-12-13 00:39
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            // 此时数组存储的是除去当前元素左边的元素乘积
            k = k * nums[i];
        }


        k = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            // k为该数右边的乘积
            res[i] = res[i] * k;
            //此时数组等于左边的 * 该数右边的。
            k = k * nums[i];
        }

        return res;
    }


    @Test
    public void testCase() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(JSONObject.toJSONString(productExceptSelf(nums)));
    }

}
