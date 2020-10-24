package com.chen.algorithm.znn.array.test26;

import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/10 16:23
 * @Description: 删除排序数组中的重复项，返回新数组长度。双指针法
 */
public class Solution {

    /**
     * 双指针法 ,数组是一个引用
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        //System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 2, 3, 4, 5, 5, 6}));
    }
}
