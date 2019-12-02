package com.chen.algorithm.study.test104;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/javasan-chong-jie-fa-xun-huan-ban-bfs-xun-huan-ban/
 * <p>
 * 深度优先遍历和广度优先遍历
 *
 * @author :  chen weijie
 * @Date: 2019-11-01 00:25
 */
public class Solution {


    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    @Test
    public void testCase() {

        TreeNode root = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(2);


        TreeNode left3_3 = new TreeNode(3);
        TreeNode right4_4 = new TreeNode(4);

        root.setLeft(left2);
        root.setRight(right2);

        right2.setLeft(right4_4);
        right2.setRight(left3_3);

        System.out.println(maxDepth(root));


    }


}
