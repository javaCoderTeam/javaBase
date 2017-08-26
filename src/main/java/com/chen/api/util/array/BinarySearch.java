package com.chen.api.util.array;

import java.util.Arrays;

/**
 * Created by Chen Weijie on 2017/7/16.
 */
public class BinarySearch {


    public static void main(String[] args) {

        int[] intArray = {1, 9, 2, 5, 3, 6};
        Arrays.sort(intArray);
        System.out.println(search(intArray, 3));
    }


    private static int search(int[] a, int searchDes) {

        int start = 0;
        int end = a.length;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int midValue = a[mid];

            if (midValue > searchDes)
                end = mid - 1;
            else if (midValue < searchDes)
                start = mid + 1;
            else
                return mid;
        }

        return -(start + 1);
    }


}
