package com.chen.algorithm.study.test50;

/**
 * @author :  chen weijie
 * @Date: 2020-05-22 02:52
 */
public class Solution3 {


    public double myPow(double x, int n) {


        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return quick(x, n);
    }


    public double quick(double x, int n) {

        if (n == 0) {
            return 1d;
        }
        double y = quick(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }


}
