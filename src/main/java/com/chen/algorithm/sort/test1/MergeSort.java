package com.chen.algorithm.sort.test1;

/**
 * @author :  chen weijie
 * @Date: 2020-07-04 20:10
 */
public class MergeSort {


    public static int[] mergeSort(int[] aArray, int[] bArray) {
        int pointA = 0;
        int pointB = 0;

        int aLength = aArray.length;
        int bLength = bArray.length;
        int resultPoint = 0;
        int[] result = new int[aLength + bLength];

        while (pointA < aLength && pointB < bLength) {
            if (aArray[pointA] > bArray[pointB]) {
                result[resultPoint++] = bArray[pointB++];
            } else {
                result[resultPoint++] = aArray[pointA++];
            }
        }

        while (pointA < aLength) {
            result[resultPoint++] = aArray[pointA++];
        }

        while (pointB < bLength) {
            result[resultPoint++] = bArray[pointB++];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] a = {2, 5, 7, 8, 9, 10};
        int[] b = {1, 2, 3, 5, 6, 10, 29};


        int[] c = mergeSort(a, b);

        for (int i = 0; i < c.length - 1; i++) {
            System.out.println(c[i]);
        }
        System.out.println();


    }


}
