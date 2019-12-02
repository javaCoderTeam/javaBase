package com.chen.algorithm.study.test101;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode/
 *
 * @author :  chen weijie
 * @Date: 2019-11-01 00:02
 */
public class Solution {


    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }


    private boolean isMirror(TreeNode t1, TreeNode t2) {

        if ((t1 == null) && (t2 == null)) {
            return true;
        }

        if ((t1 == null) || (t2 == null)) {
            return false;
        }

        return (t1.val == t2.val)
                && (isMirror(t1.left, t2.right))
                && (isMirror(t1.right, t2.left));
    }


    @Test
    public void testCase() {

        TreeNode root = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(2);


        TreeNode left3 = new TreeNode(3);
        TreeNode right4 = new TreeNode(4);

        TreeNode left3_3 = new TreeNode(3);
        TreeNode right4_4 = new TreeNode(4);

        root.setLeft(left2);
        root.setRight(right2);
        left2.setLeft(left3);
        left2.setRight(right4);
        right2.setLeft(right4_4);
        right2.setRight(left3_3);

        System.out.println(isSymmetric(root));


    }


}
