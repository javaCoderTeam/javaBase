package com.chen.algorithm.znn.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: zhunn
 * @Date: 2020/11/9 18:41
 * @Description: 选择排序：O(n^2) 不稳定
 */
public class ChoiceSort {

    /**
     * 每一轮选择最小元素交换到未排定部分的开头
     *
     * @param nums
     * @return
     */
    public int[] choiceSort(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {  // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
            int minIndex = i;               // 选择无序区间 [i, len - 1] 里最小的元素的索引，交换到下标 i,即为排序部分的开头
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {36, 28, 45, 13, 67, 36, 18, 56};
        int[] res = choiceSort(nums);
        System.out.println(Arrays.toString(res));
    }

}
