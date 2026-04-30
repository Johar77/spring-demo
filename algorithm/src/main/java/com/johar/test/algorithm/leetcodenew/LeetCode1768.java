package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * @createTime : [2026/4/21 10:19]
 * @updateUser : [johar]
 * @updateTime : [2026/4/21 10:19]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1768 {

    /**
     * 给你两个字符串 word1 和 word2 。
     * 请你从 word1 开始，通过交替添加字母来合并字符串。
     * 如果一个字符串比另一个字符串长，就将多出来的字母
     * 追加到合并后字符串的末尾。
     * 返回 合并后的字符串 。
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 合并后的字符串
     */
    public String mergeAlternately(String word1, String word2) {
        if (isBlank(word1)) {
            return word2;
        }
        if (isBlank(word2)) {
            return word1;
        }

        int len1 = word1.length();
        int len2 = word2.length();
        StringBuffer sb = new StringBuffer(len1 + len2);
        int i = 0;
        for (; i < len1; i++) {
            sb.append(word1.charAt(i));
            if (i < len2) {
                sb.append(word2.charAt(i));
            }
        }
        if (i < len2) {
            sb.append(word2.substring(i, len2));
        }
        return sb.toString();
    }

    private boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    public static void main(String[] args) {
        LeetCode1768 leetCode1768 = new LeetCode1768();
        String w1 = "abc";
        String w2 = "pqr";
        System.out.println(leetCode1768.mergeAlternately(w1, w2));

        System.out.println(leetCode1768.mergeAlternately("ab", "pqrs"));

        System.out.println(leetCode1768.mergeAlternately("abcd", "pq"));
    }

}
