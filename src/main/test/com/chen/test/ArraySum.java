package com.chen.test;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-25 05:24
 */
public class ArraySum {


    public void findSum(int[] array, int sum) {

        for (int i = 0; i < array.length; i++) {
            int currSum = 0;
            int left = i;
            int right = i;
            while (currSum < sum) {
                currSum += array[right++];
            }

            if (currSum == sum) {
                for (int k = left; k < right; k++) {
                    System.out.println(array[k]);
                }
            }
            System.out.println("----");
        }
    }

    @Test
    public void test() {
        int[] num = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 7;
        findSum(num, sum);
    }

}
