package com.chen.algorithm.exercise.tree.traverseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/ 145
 * 先序遍历
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 *
 * @author :  chen weijie
 * @Date: 2020-04-29 23:31
 */
public class PostorderTraversal {


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(list, root);
        return list;
    }


    public void postOrder(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(result, node.left);
        postOrder(result, node.right);
        result.add(node.val);
    }

    public static void postOrderIteration(TreeNode head,List<Integer> list) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
    }



}
