package com.chen.algorithm.study.test169;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
 *
 * @author :  chen weijie
 * @Date: 2019-11-02 18:24
 */
public class Solution {

    public int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
        for (Integer num : nums) {
            if (numsMap.containsKey(num)) {
                int count = numsMap.get(num) + 1;
                if (count > (nums.length / 2)) {
                    return num;
                }
                numsMap.put(num, count);
            } else {
                numsMap.put(num, 1);
            }
        }
        return 0;
    }

}
