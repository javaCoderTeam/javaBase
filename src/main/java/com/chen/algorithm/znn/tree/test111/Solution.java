package com.chen.algorithm.znn.tree.test111;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度 （需要看leetcode题上面的图）
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * @Auther: zhunn
 * @Date: 2020/10/29 18:40
 * @Description: 二叉树的最小深度：1-深度优先搜索（DFS），即递归；2-广度优先搜索（BFS）(推荐)
 */
public class Solution {

    /**
     * 1-深度优先搜索（DFS），即递归
     * 叶子结点都为空，需要走到叶子结点，当一个结点为空一个结点不为空时，说明叶子结点在不为空的那个节点，返回不为空
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //if(root.left == null && root.right == null){
        //    return 1;
        //}

        int leftDepth = minDepth1(root.left);
        int rightDepth = minDepth1(root.right);

        // 叶子结点，是左右子节点都为空的节点，当某一个子节点为空时，则返回另一个结点的高度。
        // 当一个结点为空一个结点不为空时，说明**叶子结点**在不为空的那个节点。
        return root.left == null || root.right == null ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 2-广度优先搜索（BFS）(推荐)
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;

            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left == null && node.right == null) {
                    return minDepth;
                }
            }
        }
        return minDepth;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(7, new TreeNode(15), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        int res = minDepth2(root);
        System.out.println(res);
    }
}
