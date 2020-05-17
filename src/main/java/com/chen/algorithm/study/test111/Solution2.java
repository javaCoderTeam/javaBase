package com.chen.algorithm.study.test111;


/**
 * @author :  chen weijie
 * @Date: 2020-05-17 01:09
 */
public class Solution2 {


    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? 1 : Math.min(left, right) + 1;
    }
}
