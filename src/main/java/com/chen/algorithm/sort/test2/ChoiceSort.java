package com.chen.algorithm.sort.test2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2020-07-21 10:58
 */
public class ChoiceSort {

    public void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }

    @Test
    public void testCase() {
        int[] array = {4, 2, 1, 5, 10, -1};
        sort2(array);
        System.out.println(Arrays.toString(array));
    }


    public void sort2(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int tem = nums[min];
                nums[min] = nums[i];
                nums[i] = tem;
            }

        }


    }


}
