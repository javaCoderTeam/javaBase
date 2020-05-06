package com.chen.algorithm.jumpFloor;

/**
 * @author :  chen weijie
 * @Date: 2020-04-28 19:28
 */
public class JumpFloor {


    public int solution(int num) {
        if (num < 1) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }

        if (num == 2) {
            return 2;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= num; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }


    public int solution2(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return solution2(n - 1) + solution2(n - 2);
    }



}
