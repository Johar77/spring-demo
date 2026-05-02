package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/1 14:06]
 * @updateUser : [johar]
 * @updateTime : [2026/5/1 14:06]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1372 {

    /**
     * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
     * 选择二叉树中 任意 节点和一个方向（左或者右）。
     * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
     * 改变前进方向：左变右或者右变左。
     * 重复第二步和第三步，直到你在树中无法继续移动。
     * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
     * 请你返回给定树中最长 交错路径 的长度。
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        int left = longestZigZag(root.left, 1, 0);
        int right = longestZigZag(root.right, -1, 0);
        result = Math.max(left, right);
        int childLeft = longestZigZag(root.left);
        int childRight = longestZigZag(root.right);
        result = Math.max(result, childLeft);
        result = Math.max(result, childRight);

        return result;
    }

    private int longestZigZag(TreeNode node, int direction, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        if (direction == 1) {
            // direction = 1 左
            return longestZigZag(node.right, -1, depth);
        } else {
            // direction = -1 右
            return longestZigZag(node.left, 1, depth);
        }
    }

    private int maxDepth;
    public int longestZigZag1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxDepth = 0;
        dfs(root, true, 0);
        dfs(root, false, 0);

        return maxDepth;
    }

    private void dfs(TreeNode node, boolean isLeft, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (isLeft) {
            if (node.left != null) {
                dfs(node.left, false, depth + 1);
            }
            if (node.right != null) {
                dfs(node.right, true, 1);
            }
        } else {
            if (node.right != null) {
                dfs(node.right, true, depth + 1);
            }
            if (node.left != null) {
                dfs(node.left, false, 1);
            }
        }
    }


    public static void main(String[] args) {
        LeetCode1372 leetCode1372 = new LeetCode1372();
        TreeNode root = new TreeNode(1, null, new TreeNode(1, new TreeNode(1), new TreeNode(1, new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))), new TreeNode(1))));
        System.out.println(leetCode1372.longestZigZag(root));
    }
}
