package com.chen.algorithm.array;

/**
 * 二维数组，从上到下递增；从左到右递增；
 * 查找二维数组中是否含有某个整数
 *
 * @author :  chen weijie
 * @Date: 2020-04-28 19:17
 */
public class ArrayFind {


    public boolean find(int target, int[][] array) {

        int row = array.length - 1;
        int column = 0;

        while (row >= 0 && column <= array[0].length) {
            if (array[row][column] > target) {
                row--;
            } else if (array[row][column] < target) {
                column++;
            } else {
                return true;
            }
        }


        return false;
    }

}
