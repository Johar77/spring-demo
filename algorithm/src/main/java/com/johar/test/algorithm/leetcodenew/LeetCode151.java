package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/22 10:21]
 * @updateUser : [johar]
 * @updateTime : [2026/4/22 10:21]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode151 {

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.isBlank()) {
            return "";
        }
        String tmp = s.trim();
        if (tmp == null || tmp.isBlank()) {
            return "";
        }
        StringBuffer sb = new StringBuffer(tmp.length());
        int endIndex = tmp.length();
        for (int i = tmp.length() - 1; i >= 0; i--) {
            if (tmp.charAt(i) != ' ') {
                continue;
            }
            if (tmp.charAt(i + 1) == ' ') {
                endIndex = i;
                continue;
            }

            sb.append(tmp.substring(i + 1, endIndex));
            sb.append(' ');
            endIndex = i;
        }
        sb.append(tmp.substring(0, endIndex));
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode151 leetCode151 = new LeetCode151();
        System.out.println(leetCode151.reverseWords("the sky is blue"));
        System.out.println(leetCode151.reverseWords("  hello world  "));
        System.out.println(leetCode151.reverseWords("a good   example"));
    }
}
