package com.chen.algorithm.study.test107;

import java.util.*;

/**
 * @author :  chen weijie
 * @Date: 2020-09-16 14:57
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<List<Integer>> stack = new Stack<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            // res.add(list);
            stack.push(list);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }
}
