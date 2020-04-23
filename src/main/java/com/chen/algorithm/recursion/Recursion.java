package com.chen.algorithm.recursion;

/**
 * 求一个数的阶乘
 *
 * @author :  chen weijie
 * @Date: 2019-03-14 11:53 PM
 */
public class Recursion {


    /**
     * for循环处理阶乘
     * @param n
     * @return
     */
    public static int getFactorialFor(int n) {

        int temp = 1;
        if (n < 0) {
            return -1;
        } else {
            for (int i = 1; i <= n; i++) {
                temp = temp * i;
                System.out.println("i===" + i + ",temp==" + temp);
            }
        }
        return temp;
    }


    public static int getFactorial(int n) {

        if (n >= 0) {
            if (n == 0) {
                return 1;
            } else {
                return n * getFactorial(n - 1);
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(getFactorialFor(3));
        System.out.println(getFactorial(3));
    }


}
