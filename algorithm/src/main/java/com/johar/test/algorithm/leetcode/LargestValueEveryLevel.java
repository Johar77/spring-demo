package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: LargestValueEveryLevel
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/26 00:02
 * @Since: 1.0.0
 */
public class LargestValueEveryLevel {

    /**
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/#/description
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result){
        if (node == null){
            return;
        }

        int max = node.val;
        if (result.size() > level){
            max = Math.max(max, result.get(level));
            result.set(level, max);
        } else {
            result.add(max);
        }
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}