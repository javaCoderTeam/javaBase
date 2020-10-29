package com.chen.algorithm.znn.tree.test538;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 11:39
 * @Description: 把二叉搜索树转换成累加树
 */
public class Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(7, new TreeNode(6), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        TreeNode res = convertBST(root);
        System.out.println(JSON.toJSON(res));
    }
}
