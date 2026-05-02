package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/30 19:26]
 * @updateUser : [johar]
 * @updateTime : [2026/4/30 19:26]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1448 {

    /**
     * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
     * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return dfs(root, max);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;
        int temp = Math.max(root.val, max);
        int left = dfs(root.left, temp);
        int right = dfs(root.right, temp);
        if (root.val >= max) {
            return left + right + 1;
        } else {
            return left + right;
        }
    }
}
