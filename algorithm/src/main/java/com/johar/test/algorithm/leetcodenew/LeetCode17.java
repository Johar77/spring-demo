package com.johar.test.algorithm.leetcodenew;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/10 11:22]
 * @updateUser : [johar]
 * @updateTime : [2026/5/10 11:22]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            res = singleCombination(toArray(ch), res);
        }

        return res;
    }

    private List<String> singleCombination(List<String> digits, List<String> prev) {
        if (digits.isEmpty()) {
            return prev;
        }
        if (prev.isEmpty()) {
            prev.addAll(digits);
            return prev;
        }
        List<String> result = new ArrayList<>();
        for (String s : prev) {
            for (String d : digits) {
                result.add(s + d);
            }
        }

        return result;
    }

    private List<String> toArray(char ch) {
        switch (ch) {
            case '2': return List.of("a", "b", "c");
            case '3': return List.of("d", "e", "f");
            case '4': return List.of("g", "h", "i");
            case '5': return List.of("j", "k", "l");
            case '6': return List.of("m", "n", "o");
            case '7': return List.of("p", "q", "r", "s");
            case '8': return List.of("t", "u", "v");
            case '9': return List.of("w", "x", "y", "z");
            default: return List.of();
        }
    }
}
