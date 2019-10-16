package com.chen.algorithm.study.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2019-09-07 00:34
 */
public class Solution2 {


    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int[] res = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }





}
