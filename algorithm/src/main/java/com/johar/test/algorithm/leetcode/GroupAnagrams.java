package com.johar.test.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName: GroupAnagrams
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/9 16:46
 * @Since: 1.0.0
 */
public class GroupAnagrams {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     *
     * https://leetcode.cn/problems/group-anagrams/
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            String uniqueKey = computeUniqueKey(strs[i]);
            List<String> list = map.get(uniqueKey);
            if (list == null){
                list = new ArrayList<>();
            }
            list.add(strs[i]);
            map.put(uniqueKey, list);
        }

        return new ArrayList<>(map.values());
    }

    private String computeUniqueKey(String str){
        int[] code = new int[26];
        int len = str.length();
        char a = 'a';
        for (int i = 0; i < len; i++){
            char c = str.charAt(i);
            code[c - a] += 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char i = 0; i < 26; i++){
            if (code[i] > 0){
                char c = (char) (a + i);
                stringBuilder.append(c);
                stringBuilder.append(code[i]);
            }
        }

        return stringBuilder.toString();
    }


}