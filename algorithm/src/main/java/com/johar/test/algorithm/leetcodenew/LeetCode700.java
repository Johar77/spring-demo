package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/2 10:30]
 * @updateUser : [johar]
 * @updateTime : [2026/5/2 10:30]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode700 {

    /**
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
