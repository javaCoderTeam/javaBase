package com.chen.algorithm;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author :  chen weijie
 * @Date: 2020-08-05 21:25
 */
public class RevertTree {


    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.right = right;
            this.left = left;
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public TreeNode revert(TreeNode root) {

        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);

        while (!linkedList.isEmpty()) {

            int size = linkedList.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                if (node.left != null) {
                    linkedList.add(node.left);
                }

                if (node.right != null) {
                    linkedList.add(node.right);
                }

                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }


    @Test
    public void testCase() {


        TreeNode elementLeft_2_1 = new TreeNode(10, null, null);
        TreeNode elementRight_2_1 = new TreeNode(60, null, null);
        TreeNode elementLeft_2_2_1 = new TreeNode(110, null, null);

        TreeNode elementLeft_1_1 = new TreeNode(50, elementLeft_2_1, elementRight_2_1);
        TreeNode elementRight_1_1 = new TreeNode(120, elementLeft_2_2_1, null);

        TreeNode root = new TreeNode(100, elementLeft_1_1, elementRight_1_1);

        System.out.println("before===="+JSONObject.toJSONString(root));

        revert(root);

        System.out.println("after===="+JSONObject.toJSONString(root));

    }


}
