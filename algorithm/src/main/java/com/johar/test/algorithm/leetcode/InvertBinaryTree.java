package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

/**
 * @ClassName: InvertBinaryTree
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/16 16:49
 * @Since: 1.0.0
 */
public class InvertBinaryTree {

    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     *
     * https://leetcode.cn/problems/invert-binary-tree/description/
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}