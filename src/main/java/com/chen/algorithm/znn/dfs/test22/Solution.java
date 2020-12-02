package com.chen.algorithm.znn.dfs.test22;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @Auther: zhunn
 * @Date: 2020/10/24 17:23
 * @Description: 括号生成：1-dfs（推荐）
 */
public class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    /**
     * @param left   左边剩余的括号数
     * @param right  右边剩余的括号数
     * @param curStr 括号结果
     */
    private void dfs(int left, int right, String curStr) {
        // 左右括号都不剩余了，递归终止
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left > right) {
            return;
        }
        // 如果左括号还剩余的话，可以拼接左括号
        if (left > 0) {
            dfs(left - 1, right, curStr + "(");
        }
        // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
        if (right > left) {
            dfs(left, right - 1, curStr + ")");
        }
    }

    @Test
    public void test() {
        List<String> res = generateParenthesis(3);
        System.out.println(JSON.toJSONString(res));
    }
}
