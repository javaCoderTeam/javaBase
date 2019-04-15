package com.chen.algorithm.exercise.exercise4;

/**
 * 重建二叉树
 * https://www.nowcoder.com/profile/566744/codeBookDetail?submissionId=1516321
 *
 * @author :  chen weijie
 * @Date: 2019-02-23 1:02 AM
 */
public class BinaryTree {


    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode reConstructBTree(int[] pre, int[] in) {
        TreeNode root = reConstructBTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    private static TreeNode reConstructBTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }


        return root;
    }


    /**
     * 前序遍历
     *
     * @param current
     */
    public static void preOrder(TreeNode current) {
        if (current != null) {
            System.out.println(current.val + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = reConstructBTree(pre, in);
        preOrder(node);
    }


}
