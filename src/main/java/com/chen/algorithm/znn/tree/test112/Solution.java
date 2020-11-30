package com.chen.algorithm.znn.tree.test112;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 路径总和：1-递归；2-广度优先搜索(推荐)
 */
public class Solution {

    /**
     * 1-深度优先搜索
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 2-广度优先搜索(推荐)
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.add(root);
        Queue<Integer> queueSum = new LinkedList<>();
        queueSum.add(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queueNode.add(node.left);
                queueSum.add(rec);
            }
            if (node.right != null) {
                queueNode.add(node.right);
                queueSum.add(rec);
            }

        }
        return false;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1, new TreeNode(3), null);
        TreeNode right = new TreeNode(7, new TreeNode(15), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        System.out.println(hasPathSum(root, 7));
        System.out.println(hasPathSum2(root, 7));
    }
}
