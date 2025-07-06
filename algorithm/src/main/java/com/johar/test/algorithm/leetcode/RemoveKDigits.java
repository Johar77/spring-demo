package com.johar.test.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: RemoveKdigits
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/28 16:51
 * @Since: 1.0.0
 */
public class RemoveKDigits {

    /**
     * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
     *
     * https://leetcode.cn/problems/remove-k-digits/
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (k == 0){
            return num;
        }
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++){
            char c = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c){
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }

        for (int i = 0; i < k; i++){
            deque.pollLast();
        }

        StringBuilder result = new StringBuilder();
        boolean zero = true;
        while (!deque.isEmpty()){
            char c = deque.pollFirst();
            if (zero && c == '0'){
                continue;
            }

            zero = false;
            result.append(c);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

}