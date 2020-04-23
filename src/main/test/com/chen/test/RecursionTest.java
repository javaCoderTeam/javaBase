package com.chen.test;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-23 08:47
 */
public class RecursionTest {


    @Test
    public void test1() {

        int n = 3;
        int temp = 1;
        for (int i = 1; i <= n; i++) {
            temp = temp * i;
        }
        System.out.println(temp);
    }

    public int solution(int n) {

        if (n == 1) {
            return 1;
        }
        return solution(n - 1) * n;
    }

    @Test
    public void test() {

        System.out.println(solution(4));

    }


}
