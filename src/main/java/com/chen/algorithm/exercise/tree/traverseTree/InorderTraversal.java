package com.chen.algorithm.exercise.tree.traverseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ 94
 * 中序遍历
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 *
 * @author :  chen weijie
 * @Date: 2020-04-29 23:31
 */
public class InorderTraversal {


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list;
    }


    public void inOrder(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(result, node.left);
        result.add(node.val);
        inOrder(result, node.right);
    }




    public static void inOrderIteration(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
    }





    public static void inOrderIteration2(TreeNode head, List<Integer> list) {

        if (head == null ){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode current = head;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
    }




















}
