package com.chen.algorithm.sum;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: chenweijie
 * Date: 10/18/17
 * Time: 10:15 PM
 * Description: 给出一个排序好的数组和一个数，
 * 求数组中连续元素的和等于所给数的子数组
 */
public class ArraySum {


    @Test
    public void test() {
        int[] num = {2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 7;
        List<List<Integer>> res =  findSum(num, sum);
        System.out.println(JSONObject.toJSONString(res));
    }

    public List<List<Integer>> findSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        for(int i = 0 ; i<candidates.length;i++ ){
            int left =i,right =i;
            int currentSum = 0;
            while(currentSum< target){
                currentSum += candidates[right++];
            }

            List<Integer> list = new ArrayList<>();
            if(currentSum == target){
                for(int j = left; j < right ; j++){
                    list.add(candidates[j]);
                }
                res.add(list);
            }
        }
        return res;
    }


}
