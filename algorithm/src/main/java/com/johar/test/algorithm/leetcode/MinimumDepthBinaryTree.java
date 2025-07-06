package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

/**
 * @ClassName: MinimumDepthBinaryTree
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/16 17:41
 * @Since: 1.0.0
 */
public class MinimumDepthBinaryTree {

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        return minDepth(root, 0);
    }

    private int minDepth(TreeNode root, int lastDepth){
        if (root == null){
            return lastDepth;
        }
        lastDepth += 1;
        if (root.left == null && root.right == null){
            return lastDepth;
        } else if (root.left != null && root.right != null) {
            int left = minDepth(root.left, lastDepth);
            int right = minDepth(root.right, lastDepth);
            return Math.min(left, right);
        } else if (root.left != null && root.right == null) {
            int left = minDepth(root.left, lastDepth);
            return left;
        } else {
            int right = minDepth(root.right, lastDepth);
            return right;
        }
    }
}