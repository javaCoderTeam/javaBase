package com.chen.algorithm.sort.test1;

/**
 * @author :  chen weijie
 * @Date: 2020-07-04 18:47
 */
public class ChoiceSort {


    public static void sort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }

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
        sort(array);
        System.out.println("最后的结果为：");
        display(array);
    }


}
