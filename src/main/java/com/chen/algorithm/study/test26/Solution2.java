package com.chen.algorithm.study.test26;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-08 01:02
 */
public class Solution2 {


    /**
     * 双指针法 ,数组是一个引用
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }



    @Test
    public void testCase(){
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,4,4}));

    }



}
