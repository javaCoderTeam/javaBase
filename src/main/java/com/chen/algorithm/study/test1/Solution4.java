package com.chen.algorithm.study.test1;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhunn
 * @Date: 2020/10/22 19:00
 * @Description: 两数之和
 */
public class Solution4 {

    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    @Test
    public void testCase() {
        int[] array = {4, 5, 6, 7, 2};

        int[] result = twoSum1(array, 9);
        System.out.println(JSON.toJSONString(result));

    }
}
