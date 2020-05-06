package com.chen.algorithm.exercise.tree.traverseTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-ci-bian-li-by-leetcode/
 * 层序遍历
 *
 * @author :  chen weijie
 * @Date: 2020-04-29 23:31
 */
public class LevelTraverseTree {


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    List<List<Integer>> levels = new ArrayList<>();


    public List<List<Integer>> levelOrder(TreeNode TreeNode) {
        if (TreeNode == null) {
            return levels;
        }
        helper(TreeNode, 0);
        return levels;
    }


    /**
     * 递归实现
     * @param TreeNode
     * @param level
     */
    public void helper(TreeNode TreeNode, Integer level) {
        // start the current level
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        // fulfil the current level
        levels.get(level).add(TreeNode.val);
        // process child nodes for the next level
        if (TreeNode.left != null) {
            helper(TreeNode.left, level + 1);
        }
        if (TreeNode.right != null) {
            helper(TreeNode.right, level + 1);
        }
    }

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // start the current level
            levels.add(new ArrayList<>());

            // number of elements in the current level
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                TreeNode TreeNode = queue.remove();

                // fulfill the current level
                levels.get(level).add(TreeNode.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (TreeNode.left != null) {
                    queue.add(TreeNode.left);
                }
                if (TreeNode.right != null) {
                    queue.add(TreeNode.right);
                }
            }
            // go to next level
            level++;
        }
        return levels;

    }

}
