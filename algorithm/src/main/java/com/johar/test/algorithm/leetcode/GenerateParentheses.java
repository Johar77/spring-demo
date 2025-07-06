package com.johar.test.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GenerateParentheses
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/16 16:14
 * @Since: 1.0.0
 */
public class GenerateParentheses {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * https://leetcode.cn/problems/generate-parentheses/
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(0, n, null, result);
        return result;
    }

    /**
     *
     * @param count  左括号数量
     * @param n 左括号总的数量
     * @param str 字符串
     * @param result 结果
     */
    private void generateParenthesis(int count, int n, String str,  List<String> result) {
        int len = 0;
        int size = n << 1;
        if (str != null){
            len = str.length();
        } else {
            str = new String();
        }
        if (len == size){
            result.add(str);
            return;
        }

        if (count < n){
            generateParenthesis(count + 1, n, str + "(", result);
        }
        if (count > len - count){
            generateParenthesis(count, n, str + ")", result);
        }
    }
}