package com.chen.algorithm.znn.tree.test113;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * @Auther: zhunn
 * @Date: 2020/10/28 10:11
 * @Description: 路径之和 II，二叉树中和为某一值的路径：1-深度优先搜索；2-广度优先搜索（推荐）
 * 同剑指 Offer 34
 */
public class Solution {

    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    /**
     * 1-深度优先搜索
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<>(path));
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }

    List<List<Integer>> res2 = new LinkedList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();

    /**
     * 2-广度优先搜索
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return res2;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.add(root);
        Queue<Integer> queueSum = new LinkedList<>();
        queueSum.add(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
                continue;
            }
            if (node.left != null) {
                map.put(node.left, node);
                queueNode.add(node.left);
                queueSum.add(rec);
            }
            if (node.right != null) {
                map.put(node.right, node);
                queueNode.add(node.right);
                queueSum.add(rec);
            }

        }
        return res2;
    }

    private void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        res2.add(temp);
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1, new TreeNode(3), null);
        TreeNode right = new TreeNode(7, new TreeNode(15), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        List<List<Integer>> res = pathSum2(root, 7);
        System.out.println(res);
    }
}
