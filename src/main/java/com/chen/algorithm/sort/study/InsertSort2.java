package com.chen.algorithm.sort.study;

/**
 * @author Chen WeiJie
 * @date 2020-04-02 15:09:24
 **/
public class InsertSort2 {


    private void sort(int[] array) {

        int leftIndex;

        for (int i = 1; i < array.length - 1; i++) {

            int temp = array[i];
            leftIndex = i - 1;

            while (leftIndex >= 0 && temp < array[leftIndex]) {
                array[leftIndex + 1] = array[leftIndex];
                leftIndex--;
            }
            array[leftIndex + 1] = temp;
        }

    }

}
