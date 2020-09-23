package com.chen.algorithm.study.test22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-11-10 02:20
 */
public class Solution1 {


    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        generateAll("", n, n, res);
        return res;
    }


    public void generateAll(String current, int left, int right, List<String> result) {

        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        if (left > 0) {
            generateAll(current + "(", left - 1, right, result);
        }

        if (right > 0 && right > left) {
            generateAll(current + ")", left, right - 1, result);
        }
    }

    @Test
    public void testCase(){
        generateParenthesis(3).stream().forEach(System.out::println);
    }


}
