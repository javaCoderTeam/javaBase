package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-25 05:07
 */
public class BubbleSort {


    public void solution(int[] array) {


        boolean flag = false;

        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
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


}
