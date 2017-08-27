package com.chen.algorithm.sort;

import org.junit.Test;

/**
 * 快速排序练习
 *
 * @author Chen Weijie
 */
public class QuickSortTest {


    public static int partiton(int[] arr, int low, int high) {

        int pivotValue = arr[low]; //获取第一个元素为数轴

        while (low < high) {
            //从high位置往左移动，当arr[high]的元素小于数轴元素，则将arr[high]赋值给arr[low]
            while (low < high && arr[high] >= pivotValue) {
                high--;
            }
            arr[low] = arr[high];
            //从low位置往右移动，当arr[low]的元素大于数轴元素，则将arr[low]赋值给arr[high]
            while (low < high && arr[low] <= pivotValue) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivotValue;//将数轴元素赋值给arr[low]
        return low;
    }


    public static void quickSort(int arr[], int low, int high) {

        if (low < high) {
            int pivot = partiton(arr, low, high);
            partiton(arr, pivot + 1, high);
            partiton(arr, low, pivot - 1);
        }

    }


    public static void quick() {
        int[] arr = {9, 2, 58, -10, 40};
        quickSort(arr, 0, arr.length - 1);
        for (int n : arr) {
            System.out.println(n);
        }

    }


    @Test
    public void testMain() {
        quick();
    }


}
