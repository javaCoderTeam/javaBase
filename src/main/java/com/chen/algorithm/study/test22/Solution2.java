package com.chen.algorithm.study.test22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2020-05-17 02:17
 */
public class Solution2 {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generationOneByOne("", combinations, n, n);
        return combinations;

    }

    /**
     * @param subList 子字符串
     * @param result
     * @param left    左括号还剩多少个
     * @param right   右括号还剩多少个
     */
    public void generationOneByOne(String subList, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(subList);
            return;
        }

        if (left > 0) {
            generationOneByOne(subList + "(", result, left-1, right);
        }

        // 子字符串中肯定是左括号多余右括号的
        if (right > 0 && right > left) {
            generationOneByOne(subList + ")", result, left, right-1);
        }
    }

    @Test
    public void testCase(){
        generateParenthesis(3).stream().forEach(System.out::println);
    }


}
