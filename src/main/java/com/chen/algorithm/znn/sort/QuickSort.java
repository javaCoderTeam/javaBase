package com.chen.algorithm.znn.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 重点
 *
 * @Auther: zhunn
 * @Date: 2020/11/9 18:41
 * @Description: 快速排序：O(nlogn) 不稳定
 */
public class QuickSort {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int hight) {
        if (low >= hight) {
            return;
        }
        // 枢轴（基准值）
        int pivot = partition(nums, low, hight);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, hight);
    }

    private int partition(int[] nums, int low, int hight) {
        int pivotValue = nums[low];
        while (low < hight) {
            while (low < hight && pivotValue <= nums[hight]) {
                hight--;
            }
            nums[low] = nums[hight];
            while (low < hight && nums[low] <= pivotValue) {
                low++;
            }
            nums[hight] = nums[low];
        }
        //System.out.println(low==hight);
        nums[low] = pivotValue;
        return low;
    }

    @Test
    public void test() {
        int[] nums = {3, 7, 2, 7, 10, -1, 6};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }

}
