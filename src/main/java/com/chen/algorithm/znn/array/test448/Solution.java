package com.chen.algorithm.znn.array.test448;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/e-wai-liang-ge-intkong-jian-shi-jian-fu-za-du-jin-/
 *
 * @author: zhunn
 * @Date: 2020-10-04 00:06
 * @@Description: zhunn 找到所有数组中消失的数字
 */
public class Solution {


    public List<Integer> findDisappearedNumbers(int[] nums) {

        int temp = 0;
        int nextIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                temp = nums[i];
                while (temp > 0) {
                    nums[i] = 0;
                    nextIndex = nums[temp - 1];
                    nums[temp - 1] = -1;
                    temp = nextIndex;
                }
            }

        }


        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result.add(i + 1);
            }
        }

        return result;
    }


    @Test
    public void testCase() {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> list = findDisappearedNumbers(nums);
        list.forEach(System.out::println);

    }


}
