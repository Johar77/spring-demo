package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/1 0:01]
 * @updateUser : [johar]
 * @updateTime : [2026/5/1 0:01]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode437 {

    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int result = rootSum(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }

    private int rootSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int val = root.val;
        int result = 0;
        if (val == sum) {
            result++;
        }

        result += rootSum(root.left, sum - root.val);
        result += rootSum(root.right, sum - root.val);
        return result;
    }

    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        /**
         * key:从根节点到node节点值之和
         * value：节点值之和出现的次数
         */
        Map<Long, Integer> cnt = new HashMap<Long, Integer>();
        cnt.put(0L, 1);

        return dfs(root, 0, targetSum, cnt);
    }


    private int dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return 0;
        }

        s += node.val;
        int result = cnt.getOrDefault(s - targetSum, 0);

        cnt.merge(s, 1, Integer::sum);
        result += dfs(node.left, s, targetSum, cnt);
        result += dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum);

        return result;
    }
}
