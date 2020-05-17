package com.chen.algorithm.study.test111;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  chen weijie
 * @Date: 2020-05-17 01:17
 */
public class Solution {

    public int minDepth(TreeNode root) {

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


}
