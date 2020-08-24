package com.chen.algorithm.study.test226;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  chen weijie
 * @Date: 2020-08-03 23:01
 */
public class Solution2 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode revertTree(TreeNode root) {


        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }


}
