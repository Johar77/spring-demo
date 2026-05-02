package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/2 10:08]
 * @updateUser : [johar]
 * @updateTime : [2026/5/2 10:08]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode199 {

    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }

        return result;
    }
}
