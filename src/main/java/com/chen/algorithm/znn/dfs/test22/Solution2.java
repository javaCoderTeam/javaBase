package com.chen.algorithm.znn.dfs.test22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 *
 * @Auther: zhunn
 * @Date: 2020/10/24 17:23
 * @Description: 括号生成：2-bfs
 */
public class Solution2 {
    class Node {
        private String str; // 当前得到的字符串
        private int left; // 剩余的左括号数量
        private int right; // 剩余的右括号数量

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 2-bfs
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("", n, n));
        List<String> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left == 0 && node.right == 0) {
                res.add(node.str);
            }
            if (node.left > 0) {
                queue.add(new Node(node.str + "(", node.left - 1, node.right));
            }
            if (node.right > 0 && node.left < node.right) {
                queue.add(new Node(node.str + ")", node.left, node.right - 1));
            }
        }
        return res;
    }
}
