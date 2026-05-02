package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/30 17:33]
 * @updateUser : [johar]
 * @updateTime : [2026/4/30 17:33]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode104 {

    /**
     * 给定一个二叉树 root ，返回其最大深度。
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
        }

        return depth;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
