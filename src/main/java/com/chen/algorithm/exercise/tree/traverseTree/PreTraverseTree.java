package com.chen.algorithm.exercise.tree.traverseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/ 144
 * 先序遍历
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 *
 * @author :  chen weijie
 * @Date: 2020-04-29 23:31
 */
public class PreTraverseTree {


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        preOrder(list, root);
        preOrderIteration(root, list);
        return list;
    }


    public void preOrder(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preOrder(result, node.left);
        preOrder(result, node.right);
    }


    /**
     * 迭代实现
     *
     * @param head
     */
    public static void preOrderIteration(TreeNode head, List<Integer> list) {

        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


}
