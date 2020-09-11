package com.chen.algorithm.sort.test2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2020-07-21 11:12
 */
public class InsertSort {


    public void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int leftIndex = i - 1;
            int temp = array[i];
            while (leftIndex >= 0 && temp < array[leftIndex]) {
                array[leftIndex + 1] = array[leftIndex];
                leftIndex--;
            }
            array[leftIndex + 1] = temp;
        }
    }


    @Test
    public void testCase() {
        int[] array = {4, 2, 1, 5, 10, -1};
        sort2(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort2(int[] nums) {


        for (int i = 1; i < nums.length; i++) {

            int leftIndex = i - 1;
            int temp = nums[i];

            while (leftIndex >= 0 && nums[leftIndex] > temp) {
                nums[leftIndex + 1] = nums[leftIndex];
                leftIndex--;
            }
            nums[leftIndex + 1] = temp;

        }


    }


}
