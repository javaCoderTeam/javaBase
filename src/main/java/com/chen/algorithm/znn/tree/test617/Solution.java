package com.chen.algorithm.znn.tree.test617;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 14:50
 * @Description: 合并二叉树
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode mergeTree = new TreeNode(t1.val + t2.val);
        mergeTree.left = mergeTrees(t1.left, t2.left);
        mergeTree.right = mergeTrees(t1.right, t2.right);
        return mergeTree;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(7, new TreeNode(5), new TreeNode(6));
        TreeNode root = new TreeNode(3, left, right);

        TreeNode right2 = new TreeNode(8);
        TreeNode left2 = new TreeNode(7, new TreeNode(1), new TreeNode(2));
        TreeNode root2 = new TreeNode(3, left2, right2);

        TreeNode res = mergeTrees(root, root2);
        System.out.println(JSON.toJSON(res));
    }
}
