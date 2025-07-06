package com.johar.test.algorithm.tree;

/**
 * @ClassName: TreeNode
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/5 23:03
 * @Since: 1.0.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}