package com.chen.algorithm.znn.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: zhunn
 * @Date: 2020/11/9 18:41
 * @Description: 插入排序：O(n^2) 稳定
 * 稳定排序，在接近有序的情况下，表现优异
 */
public class InsertSort {

    public int[] insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {     // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
            int temp = nums[i];     // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int left = i - 1;
            // 注意边界 left >= 0
            while (left >= 0 && nums[left] > temp) {
                nums[left + 1] = nums[left];
                left--;
            }
            nums[left + 1] = temp;
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {6, 8, 2, 1, 2, 7};
        int[] res = insertSort(nums);
        System.out.println(Arrays.toString(res));
    }
}
