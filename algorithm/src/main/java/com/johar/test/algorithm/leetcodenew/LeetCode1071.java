package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/21 10:34]
 * @updateUser : [johar]
 * @updateTime : [2026/4/21 10:34]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1071 {

    /**
     * 对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
     * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 结果
     */
    public String gcdOfStrings(String str1, String str2) {
        if (isBlank(str1) || isBlank(str2)) {
            return "";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = Math.min(len1, len2); i > 0; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String str = str1.substring(0, i);
                if (check(str, str1) && check(str, str2)) {
                    return str;
                }
            }
        }

        return "";
    }

    private boolean check(String t, String s) {
        int lent = s.length() / t.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < lent; i++) {
            sb.append(t);
        }

        return sb.toString().equals(s);
    }

    private boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    public String gcdOfStrings1(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        LeetCode1071 leetcode = new LeetCode1071();
        System.out.println(leetcode.gcdOfStrings1("AAAAAA", "AAA"));
    }
}
