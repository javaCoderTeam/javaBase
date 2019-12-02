package com.chen.algorithm.sort.study;

/**
 * @author :  chen weijie
 * @Date: 2019-11-27 00:21
 */
public class InsertSort {


    public void solution(int[] array) {

        int leftIndex;
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            //记录要插入的数据
            int temp = array[i];
            leftIndex = i - 1;
            //从已经排序的序列最右边的开始比较，找到比其小的数
            while (leftIndex >= 0 && temp < array[leftIndex]) {
                //向后挪动
                array[leftIndex + 1] = array[leftIndex];
                leftIndex--;
            }
            //存在比其小的数，插入
            array[leftIndex + 1] = temp;
        }

    }


}
