package com.chen.algorithm.znn.tree.test104;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 17:57
 * @Description: 二叉树的最大深度：1-递归；2-广度优先搜索（BFS-层次遍历）
 */
public class Solution {

    /**
     * 1-递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 2-广度优先搜索（层次遍历）
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(7, new TreeNode(15), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        int res = maxDepth2(root);
        System.out.println(res);
    }

}
