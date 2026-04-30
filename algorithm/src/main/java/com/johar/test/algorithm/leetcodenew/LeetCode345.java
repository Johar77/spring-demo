package com.johar.test.algorithm.leetcodenew;

import java.util.*;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/21 12:38]
 * @updateUser : [johar]
 * @updateTime : [2026/4/21 12:38]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode345 {

    private Set<Character> specialSet = Set.of('a','e','i','o','u','A','E','I','O','U');

    /**
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     *
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        List<Character> charList = new ArrayList<Character>();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (specialSet.contains(s.charAt(i))) {
                charList.add(s.charAt(i));
                indexList.add(i);
            }
        }

        if (charList.isEmpty()) {
            return s;
        }
        Collections.reverse(charList);
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < charList.size(); i++) {
            int index = indexList.get(i);
            sb.setCharAt(index, charList.get(i));
        }

        return sb.toString();
    }
}
