package com.chen.test.sort;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-25 10:43
 */
public class QuickSort {


    @Test
    public void quickSort() {

        int[] nums = {3, 7, 2, 10, -1, 4};
        sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    public void sort(int[] array, int low, int high) {

        if (high > low) {
            int pivot = quickSort(array, low, high);
            sort(array, low, pivot-1);
            sort(array, pivot + 1, high);
        }

    }


    public int quickSort(int[] array, int low, int high) {

        int pivotValue = array[low];

        while (low < high) {

            while (low < high && array[high] >= pivotValue) {
                --high;
            }
            //交换比枢轴小的记录到左端
            array[low] = array[high];
            while (low < high && array[low] <= pivotValue) {
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = pivotValue;
        return low;
    }


}
