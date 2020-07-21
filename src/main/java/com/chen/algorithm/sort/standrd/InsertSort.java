package com.chen.algorithm.sort.standrd;

/**
 * @author :  chen weijie
 * @Date: 2019-03-01 12:35 AM
 */
public class InsertSort {


    public static void sort(int[] array) {

        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            //记录要插入的数据
            int temp = array[i];
            int leftIndex = i - 1;
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

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {6,8,1,2,4};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        sort2(array);
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
        display(array);
    }


    public static void sort2(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int leftIndex = i - 1;
            while (leftIndex >= 0 && temp < array[leftIndex]) {
                array[leftIndex + 1] = array[leftIndex];
                leftIndex--;
            }
            array[leftIndex + 1] = temp;
        }
    }

}
