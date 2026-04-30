package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/23 10:18]
 * @updateUser : [johar]
 * @updateTime : [2026/4/23 10:18]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode392 {

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）
     * 字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * 进阶：
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
     * 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (isBlank(s)) {
            return true;
        }
        if (!isBlank(s) && isBlank(t)) {
            return false;
        }
        if (s.length() > t.length()) {
            return false;
        }

        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }

        return sIndex == s.length();
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}
