package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/2 10:21]
 * @updateUser : [johar]
 * @updateTime : [2026/5/2 10:21]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1161 {

    /**
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
     * 返回总和 最大 的那一层的层号 x。如果有多层的总和一样大，返回其中 最小 的层号 x。
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int index = 0;
        long maxSum = Long.MIN_VALUE;
        int maxIndex = 0;
        while (!queue.isEmpty()) {
            index++;
            int size = queue.size();
            long tempSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                tempSum += node.val;
            }
            if (tempSum > maxSum) {
                maxSum = tempSum;
                maxIndex = index;
            }
        }

        return maxIndex;
    }
}
