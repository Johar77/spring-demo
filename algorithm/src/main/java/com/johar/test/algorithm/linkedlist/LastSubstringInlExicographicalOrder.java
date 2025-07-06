package com.johar.test.algorithm.linkedlist;

import org.springframework.beans.factory.FactoryBean;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName: LastSubstringInlExicographicalOrder
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/4/24 23:27
 * @Since: 1.0.0
 */
public class LastSubstringInlExicographicalOrder {

    /**
     * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串
     * 输入：s = "abab"
     * 输出："bab"
     * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
     *
     * 输入：s = "leetcode"
     * 输出："tcode"
     *
     * https://leetcode.cn/problems/last-substring-in-lexicographical-order/
     * @param s
     * @return
     */
    public String lastSubstring1(String s) {
        if (Objects.isNull(s) || s.length() == 1){
            return s;
        }

        int length = s.length();
        int startIndex = length - 1;
        char[] chars = s.toCharArray();
        for (int i = startIndex - 1; i >= 0; i--){
            if (chars[i] < chars[startIndex]){
                continue;
            }
            if (chars[i] > chars[startIndex]){
                startIndex = i;
                continue;
            }
            if (startIndex + 1 >= length){
                startIndex = i;
                continue;
            }
            String left = s.substring(i + 1);
            String right = s.substring(startIndex + 1);
            if (left.compareTo(right) > 0){
                startIndex = i;
            }
        }
        return s.substring(startIndex, length);
    }

    public static String lastSubstring(String s) {
        if (Objects.isNull(s) || s.length() == 1){
            return s;
        }

        int i = 0, j = 1;
        int length = s.length();
        for (int k = 0; j + k < length; ){
            int d = s.charAt(i + k) - s.charAt(j + k);
            if (d == 0){
                k++;
            } else if (d < 0){
                i = i + k + 1;
                k = 0;
                if (i >= j){
                    j = i + 1;
                }
            } else {
                j = j + k + 1;
                k = 0;
            }
        }

        return s.substring(i);
    }


    public static void main(String[] args) {
        String a = "aa";
        String b = "aaaa";
        String c = "ab";
        System.out.println(a.compareTo(b));
        System.out.println(c.compareTo(b));
        System.out.println(c.compareTo(a));
    }
}