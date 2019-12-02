package com.chen.algorithm.study.test437;

import org.junit.Test;

/**
 * https://www.jianshu.com/p/2c2efb9bf25c
 *
 *
 * @author :  chen weijie
 * @Date: 2019-11-03 23:25
 */
public class Solution {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 求以 root 为根的二叉树，所有和为 sum 的路径；
     * 路径的开头不一定是 root，结尾也不一定是叶子节点；
     *
     * @param root
     * @param sum
     * @return
     */

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return paths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }


    private int paths(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += paths(root.left, sum - root.val);
        res += paths(root.right, sum - root.val);
        return res;
    }




    @Test
    public void testCase(){

        TreeNode treeNode3 = new TreeNode(3);
        treeNode3.left = new TreeNode(3);
        treeNode3.right = new TreeNode(-2);

        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.right = new TreeNode(1);

        TreeNode treeNode5 = new TreeNode(5);
        treeNode5.right =treeNode2;
        treeNode5.left =treeNode3;

        TreeNode treeNode3_ = new TreeNode(-3);
        treeNode3_.right = new TreeNode(11);

        TreeNode root = new TreeNode(10);
        root.left = treeNode5;
        root.right = treeNode3_;

        System.out.println(pathSum(root,7));

    }









}
