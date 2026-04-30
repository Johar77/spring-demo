package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/27 10:44]
 * @updateUser : [johar]
 * @updateTime : [2026/4/27 10:44]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode2390 {

    /**
     * 给你一个包含若干星号 * 的字符串 s 。
     * 在一步操作中，你可以：
     * 选中 s 中的一个星号。
     * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
     * 返回移除 所有 星号之后的字符串。
     * @param s
     * @return
     */
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) == '*')) {
                sb.append(s.charAt(i));
                left = sb.length() - 1;
            } else {
                if (left >= 0) {
                    sb.deleteCharAt(left--);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode2390 leetcode2390 = new LeetCode2390();
        System.out.println(leetcode2390.removeStars("leet**cod*e"));
        System.out.println(leetcode2390.removeStars("erase*****"));
    }
}
