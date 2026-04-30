package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/24 10:34]
 * @updateUser : [johar]
 * @updateTime : [2026/4/24 10:34]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1456 {

    /**
     * 给你字符串 s 和整数 k 。
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     * 英文中的 元音字母 为（a, e, i, o, u）。
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        if (s == null || s.isBlank()) {
            return 0;
        }
        int total = 0;
        int start = 0;
        int end = k - 1;
        for (int i = start; i <= end; i++) {
           total += countNum(s.charAt(i));
        }

        int leftSum = 0;
        int rightSum = 0;
        while (end < s.length() - 1) {
            leftSum += countNum(s.charAt(start));
            rightSum += countNum(s.charAt(end + 1));
            if (rightSum > leftSum) {
                total += rightSum - leftSum;
                leftSum = 0;
                rightSum = 0;
            }
            start++;
            end++;
        }

        return total;
    }

    private int countNum(char ch) {
        return "aeiou".indexOf(ch) >= 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        LeetCode1456 leetcode = new LeetCode1456();
        System.out.println(leetcode.maxVowels("abciiidef", 3));
        System.out.println(leetcode.maxVowels("aeiou", 2));
        System.out.println(leetcode.maxVowels("leetcode", 3));
        System.out.println(leetcode.maxVowels("rhythms", 4));
        System.out.println(leetcode.maxVowels("tryhard", 4));
    }
}
