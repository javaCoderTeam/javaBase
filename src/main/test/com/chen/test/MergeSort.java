package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-22 07:43
 */
public class MergeSort {


    public void solution(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0, j = 0, l = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[l++] = a[i++];
            } else {
                result[l++] = b[j++];
            }
        }

        while (j < b.length) {
            result[l++] = b[j++];
        }
        while (i < a.length) {
            result[l++] = a[i++];
        }
    }


    public boolean checkSort(int[] array) {

        boolean change = true;
        for (int i = 0; i < array.length && change; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                change = array[j] <= array[j + 1];
            }
        }
        return change;
    }



}
