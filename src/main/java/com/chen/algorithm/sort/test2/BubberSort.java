package com.chen.algorithm.sort.test2;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-07-21 10:42
 */
public class BubberSort {

    public void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
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
