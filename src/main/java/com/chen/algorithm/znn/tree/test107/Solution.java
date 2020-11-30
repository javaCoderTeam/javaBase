package com.chen.algorithm.znn.tree.test107;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @Auther: zhunn
 * @Date: 2020/10/28 15:50
 * @Description: 二叉树的层次遍历II
 */
public class Solution {

    /**
     * 使用队列存储每层元素，用栈存储每层的结果集
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            stack.push(subList);
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * （推荐）使用java的LinkedList的性质，从上到下遍历，将新遍历的层结果集放入linkedlist的头部
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(0, subList);
        }

        return res;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);

        List<List<Integer>> res = levelOrderBottom1(root);
        System.out.println(JSON.toJSON(res));
    }
}
