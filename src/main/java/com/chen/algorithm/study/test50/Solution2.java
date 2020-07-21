package com.chen.algorithm.study.test50;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-16 23:15
 */
public class Solution2 {

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0d;
        double x_contribution = x;
        while (N > 0) {
            if (N % 2 == 1) {
                result = result * x_contribution;
            }

            x_contribution = x_contribution * x_contribution;
            N = N / 2;
        }
        return result;
    }


    @Test
    public void testCase(){
        System.out.println(myPow(2.0,5));
    }
}
