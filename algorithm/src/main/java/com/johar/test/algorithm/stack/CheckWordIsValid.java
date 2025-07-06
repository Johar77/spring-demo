package com.johar.test.algorithm.stack;

import java.util.Stack;

/**
 * @ClassName: CheckWordIsValid
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/3 23:22
 * @Since: 1.0.0
 */
public class CheckWordIsValid {

    /**
     * 给你一个字符串 s ，请你判断它是否 有效 。
     * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
     * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
     * 如果字符串 s 有效，则返回 true；否则，返回 false。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            stringBuilder.append(s.charAt(i));
            if (stringBuilder.length() >= 3 && stringBuilder.substring(stringBuilder.length() - 3).equals("abc")){
                stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
            }
        }

        return stringBuilder.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabcbc"));
        System.out.println(isValid("abcabcababcc"));
        System.out.println(isValid("abccba"));
    }
}