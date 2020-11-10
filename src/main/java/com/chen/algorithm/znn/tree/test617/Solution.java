package com.chen.algorithm.znn.tree.test617;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 示例 1:
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
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
