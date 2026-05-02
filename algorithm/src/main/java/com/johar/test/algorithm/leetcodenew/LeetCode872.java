package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/30 17:55]
 * @updateUser : [johar]
 * @updateTime : [2026/4/30 17:55]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode872 {

    /**
     * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
     * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leftNodeList1 = new ArrayList<>();
        List<Integer> leftNodeList2 = new ArrayList<>();
        dfs(root1, leftNodeList1);
        dfs(root2, leftNodeList2);

        if (leftNodeList1.size() != leftNodeList2.size()) {
            return false;
        }
        for (int i = 0; i < leftNodeList1.size(); i++) {
            if (!Objects.equals(leftNodeList1.get(i), leftNodeList2.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void dfs(TreeNode root, List<Integer> leftNodeList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leftNodeList.add(root.val);
        }
        dfs(root.left, leftNodeList);
        dfs(root.right, leftNodeList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(200));
        LeetCode872 leetCode872 = new LeetCode872();
        System.out.println(leetCode872.leafSimilar(root, root));
    }
}
