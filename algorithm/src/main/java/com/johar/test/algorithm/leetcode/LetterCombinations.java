package com.johar.test.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: LetterCombinations
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/23 11:27
 * @Since: 1.0.0
 */
public class LetterCombinations {

    private Map<Character, String> map = null;

    public LetterCombinations() {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkt");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs(digits, "", 0, result);
        return result;
    }

    private void dfs(String digits, String path, int index, List<String> result){
        if (digits.length() == index){
            result.add(path);
            return;
        }

        char c = digits.charAt(index);
        String letters = map.get(c);
        for (int i = 0; i < letters.length(); i++){
            dfs(digits, path + letters.charAt(i), index + 1, result);
        }
    }

}