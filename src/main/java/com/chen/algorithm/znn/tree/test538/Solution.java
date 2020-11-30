package com.chen.algorithm.znn.tree.test538;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/ba-er-cha-sou-suo-shu-zhuan-huan-wei-lei-jia-sh-14/
 * 538. 把二叉搜索树转换为累加树（需要看leetcode题上面的图）
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * 示例 1：
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 *
 * @Auther: zhunn
 * @Date: 2020/10/29 11:39
 * @Description: 把二叉搜索树转换成累加树：递归-反序中序遍历
 */
public class Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

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
