package com.chen.algorithm.sort.standrd;

import org.junit.Test;

/**
 * 如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，
 * 前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 * 根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了
 * <p>
 * 快速排序
 * create by chewj1103
 */
public class QuickSort {


    @Test
    public void quickSort() {

        int[] nums = {3, 7, 2, 10, -1, 4};
        sort(0, nums.length - 1, nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    private static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            //将数组分为两部分
            int pivot = partition(arr, low, high);
            //递归排序左子数组
            qSort(arr, low, pivot - 1);
            //递归排序右子数组
            qSort(arr, pivot + 1, high);
        }
    }


    private static int partition(int[] arr, int low, int high) {
        //枢轴记录
        int pivotValue = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivotValue) {
                --high;
            }
            //交换比枢轴小的记录到左端
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivotValue) {
                ++low;
            }
            //交换比枢轴小的记录到右端
            arr[high] = arr[low];
        }
        //扫描完成，枢轴到位
        arr[low] = pivotValue;
        //返回的是枢轴的下标
        return low;
    }


    public static void sort(int left, int right, int[] nums) {
        if (left < right) {
            int pivot = partSort(left, right, nums);
            sort(left, pivot - 1, nums);
            sort(pivot + 1, right, nums);
        }
    }


    public static int partSort(int left, int right, int[] nums) {

        int pivotValue = nums[left];
        while (left < right) {
            while (left < right && pivotValue <= nums[right]) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && pivotValue >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];

        }
        nums[left] = pivotValue;
        return left;
    }


}





