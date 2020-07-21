package com.chen.algorithm.exercise.exercise4;

/**
 * @author Chen WeiJie
 * @date 2020-04-21 18:07:23
 **/
public class TwoBranchTree {


    public static class TreeNode {

        int value;

        TreeNode leftNode;

        TreeNode rightNode;


    }


    private TreeNode root = new TreeNode();


    /**
     * 二叉树查找
     *
     * @param value
     * @return
     */
    public TreeNode findNode(int value) {

        if (root == null) {
            return null;
        }

        while (true) {

            if (root == null) {
                return null;
            }

            if (root.value == value) {
                return root;
            } else if (value > root.value) {
                root = root.rightNode;
            } else {
                root = root.leftNode;
            }
        }
    }


    public void insertNode(TreeNode newNode) {


        TreeNode parent = root;
        while (true) {
            if (root == null) {
                break;
            }

            parent = root;
            if (root.value < newNode.value) {
                root = root.rightNode;
            } else {
                root = root.leftNode;
            }

        }


        if (parent != null) {
            if (newNode.value < parent.value) {
                parent.leftNode = newNode;
            } else {
                parent.rightNode = newNode;
            }

        }


    }


}
