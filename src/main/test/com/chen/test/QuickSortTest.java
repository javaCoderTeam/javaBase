package com.chen.test;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-27 00:15
 */
public class QuickSortTest {


    @Test
    public void solution() {

        int[] array = {4, 3, 1, 0, 6, 5, 10};

        sort(array, 0, array.length - 1);
    }


    public void sort(int[] array, int low, int high) {
        Integer pivot = getPivot(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
        for (int num : array) {
            System.out.print(num);
        }
    }


    private int getPivot(int[] array, int low, int high) {
        int pivotValue = array[low];

        while (low < high) {
            while (low < high && array[high] >= pivotValue) {
                --high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivotValue) {
                ++low;
            }
            array[high] = array[low];
        }

        array[low] = pivotValue;
        return low;
    }


}
