package com.chen.algorithm.sort.test1;

/**
 * @author :  chen weijie
 * @Date: 2020-07-04 18:48
 */
public class InsertSort {


    public static void insertSort(int[] nums) {


        if (nums == null || nums.length == 0) {
            return;
        }


        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int leftIndex = i - 1;

            while (leftIndex >= 0 && temp < nums[leftIndex]) {
                nums[leftIndex + 1] = nums[leftIndex];
                leftIndex--;
            }
            nums[leftIndex + 1] = temp;
        }
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
        insertSort(array);
        System.out.println("最后的结果为：");
        display(array);
    }


}
