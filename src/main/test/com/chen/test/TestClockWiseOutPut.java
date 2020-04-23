package com.chen.test;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-23 08:16
 */
public class TestClockWiseOutPut {


    @Test
    public void test() {

        int[][] array = new int[100][100];
        int n = 4;
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = count++;
            }
        }
        output(0, n - 1, array);
    }


    public void output(int start, int end, int[][] array) {
        if (end < start || start < 0) {
            return;
        }

        for (int i = start; i <= end; i++) {
            System.out.println(array[start][i]);
        }

        for (int i = start + 1; i <= end; i++) {
            System.out.println(array[i][end]);
        }

        for (int i = end - 1; i >= start; i--) {
            System.out.println(array[end][i]);
        }

        for (int i = end - 1; i >= start + 1; i--) {
            System.out.println(array[start][i]);
        }

        output(start + 1, end - 1, array);

    }


}
