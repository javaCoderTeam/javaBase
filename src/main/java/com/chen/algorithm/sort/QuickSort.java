package com.chen.algorithm.sort;

import org.junit.Test;

/**
 * 快速排序
 * create by chewj1103
 */
public class QuickSort {


    @Test
    public void quickSort() {

        int[] nums = {3, 7, 2, 10, -1, 4};
        quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 快速排序的方法入口
     *
     * @param arr 要排序的数组
     */
    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qSort(arr, low, pivot - 1);                   //递归排序左子数组
            qSort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivotValue) {
                --high;
            }
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivotValue) {
                ++low;
            }
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivotValue;
        //返回的是枢轴的下标
        return low;
    }

}
