package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: LowestCommonAncestor
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/17 23:36
 * @Since: 1.0.0
 */
public class LowestCommonAncestor {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;

        return root;
    }


}