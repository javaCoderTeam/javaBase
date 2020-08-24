package com.chen.algorithm.sort.test2;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-07-21 11:27
 */
public class QuickSort {


    public void sort(int[] array) {
        int low = 0, high = array.length - 1;
        sort(low, high, array);
    }


    public void sort(int low, int high, int[] array) {
        if (high > low) {
            int pivot = partSort(low, high, array);
            sort(pivot + 1, high, array);
            sort(low, pivot - 1, array);
        }
    }


    public int partSort(int low, int high, int[] array) {

        int pivotValue = array[low];

        while (low < high) {
            while (low < high && array[high] > pivotValue) {
                high--;
            }
            array[low] = array[high];


            while (low < high && array[low] < pivotValue) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivotValue;
        return low;
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
