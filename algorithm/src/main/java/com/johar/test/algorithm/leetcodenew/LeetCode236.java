package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/1 15:17]
 * @updateUser : [johar]
 * @updateTime : [2026/5/1 15:17]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode236 {

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点
     * p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = s.substring(left, i).indexOf(c);
            if (index >= 0){
                max = Math.max(max, i - left);
                left = left + index + 1;
            }
        }
        max = Math.max(max, s.length() - left);

        return max;
    }

    public static void main(String[] args) {
        LeetCode236 leetCode236 = new LeetCode236();
        System.out.println(leetCode236.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(leetCode236.lengthOfLongestSubstring("bbbbb"));
        System.out.println(leetCode236.lengthOfLongestSubstring("pwwkew"));
    }
}
