package com.chen.algorithm.sort.test1;

/**
 * @author :  chen weijie
 * @Date: 2020-07-04 19:36
 */
public class QuickSort {


    public static void quickSort(int[] nums, int low, int high) {


        if (nums == null || nums.length == 0) {
            return;
        }

        if (low < high) {
            int pivot = partSort(low, high, nums);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }


    private static int partSort(int low, int high, int[] nums) {

        int pivotValue = nums[low];

        while (low < high) {
            while (low < high && nums[high] > pivotValue) {
                --high;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] < pivotValue) {
                ++low;
            }
            nums[high] = nums[low];
        }

        nums[low] = pivotValue;
        return low;
    }


    /// 遍历显示数组
    public static void display(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int[] array = {3, 0, 1, 90, 2, -1, 4};
        int low = 0, high = array.length - 1;
        quickSort(array, low, high);
        System.out.println("最后的结果为：");
        display(array);
    }

}
