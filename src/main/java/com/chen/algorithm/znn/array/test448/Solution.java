package com.chen.algorithm.znn.array.test448;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/e-wai-liang-ge-intkong-jian-shi-jian-fu-za-du-jin-/
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
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
