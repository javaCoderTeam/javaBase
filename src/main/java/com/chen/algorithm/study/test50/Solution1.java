package com.chen.algorithm.study.test50;

import org.junit.Test;

/**
 * 链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 * <p>
 *
 * @author :  chen weijie
 * @Date: 2020-05-16 22:50
 */
public class Solution1 {


    public double myPow(double x, int n) {

        long N = n;

        if (N < 0) {
            N = 1 / N;
            x = -x;
        }

        double contribution = x;
        double res = 1d;

        while (N > 0) {
            if (N % 2 == 1) {
                res = res * contribution;
            }
            contribution = contribution * contribution;
            N = N / 2;
        }
        return res;
    }

    @Test
    public void testCase(){
        System.out.println(myPow(2.0,4));
    }


}

