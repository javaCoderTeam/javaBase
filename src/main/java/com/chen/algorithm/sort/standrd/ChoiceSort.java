package com.chen.algorithm.sort.standrd;

/**
 * 选择排序是每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 　　分为三步：
 * 　　①、从待排序序列中，找到关键字最小的元素
 * 　　②、如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换
 * 　　③、从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束
 *
 * @author :  chen weijie
 * @Date: 2019-02-28 12:25 AM
 */
public class ChoiceSort {


    public static int[] sort(int[] array) {

        //总共进行n-1轮比较
        for (int i = 0; i < array.length; i++) {
            int min = i;
            //每轮需要比较的次数
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    //记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            //第 i轮排序的结果为
            System.out.print("第" + (i + 1) + "轮排序后的结果为:");
            display(array);
        }

        return array;
    }


    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort2(array);
        System.out.println("-----------------------");
        System.out.println("经过选择排序后的数组顺序为：");
        display(array);
    }

    public static int[] sort2(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j <array.length ; j++) {
                if (array[j] < array[min]){
                    min = j;
                }
            }

            if (min != i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }

        }
        return array;
    }


}
