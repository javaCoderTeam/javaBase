package com.chen.test;

import org.junit.Test;

/**
 * User: chenweijie
 * Date: 10/18/17
 * Time: 10:25 PM
 * Description:
 */
public class TestArraySum {


    @Test
    public void Test() {

        int num[] = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};

        int sum = 7;

        findSum(num, sum);

    }


    public void findSum(int num[], int sum) {

        int left = 0;
        int right = 0;

        for (int i = 0; i < num.length; i++) {
            int curSum = 0;
            left = i;
            right = i;
            while (curSum < sum) {
                curSum += num[right++];
            }

            if (curSum == sum) {

                for (int j = left; j < right; j++) {
                    System.out.println(num[j] + "");
                }
            }


        }


    }


}
