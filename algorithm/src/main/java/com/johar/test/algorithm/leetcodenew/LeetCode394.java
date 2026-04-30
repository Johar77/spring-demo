package com.johar.test.algorithm.leetcodenew;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/27 11:25]
 * @updateUser : [johar]
 * @updateTime : [2026/4/27 11:25]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode394 {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * 测试用例保证输出的长度不会超过 105。
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    char l = stack.pop();
                    if (l == '[') {
                        sb = sb.reverse();
                        int num = getNum(stack);
                        String str = sb.toString().repeat(num);
                        for (char cc : str.toCharArray()) {
                            stack.push(cc);
                        }
                        break;
                    } else {
                        sb.append(l);
                    }
                }
            } else {
                stack.push(c);
            }
        }
        int len = stack.size();
        StringBuilder sb = new StringBuilder(len);
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }

    private int getNum(Deque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.peek();
            if (c < '0' || c > '9') {
                break;
            }
            sb.append(c);
            stack.pop();
        }
        sb = sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        LeetCode394 leetcode = new LeetCode394();
        System.out.println(leetcode.decodeString("3[a]10[bc]"));
        System.out.println(leetcode.decodeString("3[a2[c]]"));
        System.out.println(leetcode.decodeString("2[abc]3[cd]ef"));
        System.out.println(leetcode.decodeString("abc3[cd]xyz"));
    }
}
