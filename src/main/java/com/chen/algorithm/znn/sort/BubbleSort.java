package com.chen.algorithm.znn.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: zhunn
 * @Date: 2020/11/9 18:40
 * @Description: 冒泡排序：O(n^2)稳定
 */
public class BubbleSort {

    /**
     * 冒泡排序：
     * 初始关键字：[36 28 45 13 67 36 18 56]
     * 第一趟：13 [36 28 45 18 67 36 56]
     * 第二趟：13 18 [36 28 45 36 67 56]
     * 第三趟：13 18 28 [36 36 45 56 67]
     * 第四趟：13 18 28 36 [36 45 56 67]
     */
    public int[] bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {36, 28, 45, 13, 67, 36, 18, 56};
        int[] res = bubbleSort(nums);
        System.out.println(Arrays.toString(res));
    }
}
