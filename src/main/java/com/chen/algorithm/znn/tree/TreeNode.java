package com.chen.algorithm.znn.tree;

/**
 * @Auther: zhunn
 * @Date: 2020/10/28 10:25
 * @Description: 二叉树节点
 */
public class TreeNode {

   public int val;
   public TreeNode left;
   public TreeNode right;

   public TreeNode(){}

   public TreeNode(int val){
       this.val = val;
   }

   public TreeNode(int val, TreeNode left, TreeNode right){
       this.val = val;
       this.left = left;
       this.right = right;
   }
}
