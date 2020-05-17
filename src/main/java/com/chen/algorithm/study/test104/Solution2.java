package com.chen.algorithm.study.test104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  chen weijie
 * @Date: 2020-05-17 01:09
 */
public class Solution2 {


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;

            int length = queue.size();
            for (int i = 0; i < length; i++) {
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
}
