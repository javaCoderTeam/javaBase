package com.chen.algorithm.znn.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: zhunn
 * @Date: 2020/11/9 18:41
 * @Description: 归并排序：O(nlogn) 稳定，非原地排序
 */
public class MergeSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int hight) {
        if (low >= hight) {
            return;
        }
        int mid = low + (hight - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, hight);
        merge(nums, low, mid, hight);
    }

    public void merge(int[] nums, int low, int mid, int hight) {
        int i = low;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[hight - low + 1];

        while (i <= mid && j <= hight) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= hight) {
            temp[k++] = nums[j++];
        }

        for (int m = 0; m < temp.length; m++) {
            nums[low + m] = temp[m];
        }
    }

    @Test
    public void test() {
        int[] nums = {6, 8, 2, 1, 2, 7};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }

}
