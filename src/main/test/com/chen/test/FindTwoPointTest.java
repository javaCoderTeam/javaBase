package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-23 08:53
 */
public class FindTwoPointTest {


    public int solution(int[] n, int target) {


        int min = 0;
        int max = n.length;
        int mid = min + (max - min) >>> 1;

        while (max > min) {
            if (target == n[mid]) {
                return mid;
            }
            if (target > n[mid]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1;


    }


}
