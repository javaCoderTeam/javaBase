package com.chen.algorithm.sort.test2;

import org.junit.Test;

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
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


}
