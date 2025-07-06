package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

/**
 * @ClassName: MaximumDepthBinaryTree
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/16 17:31
 * @Since: 1.0.0
 */
public class MaximumDepthBinaryTree {

    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int lastDepth){
        if (root == null){
            return lastDepth;
        }
        lastDepth += 1;
        int left = maxDepth(root.left, lastDepth);
        int right = maxDepth(root.right, lastDepth);
        return Math.max(left, right);
    }


}