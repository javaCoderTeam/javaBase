package com.chen.algorithm.znn.tree.test112;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 路径总和：1-递归；2-广度优先搜索
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
     * 2-广度优先搜索
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
