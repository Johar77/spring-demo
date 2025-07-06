package com.johar.test.algorithm.leetcode;

import java.util.Objects;

/**
 * @ClassName: LongestPalindromicSubstring
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/27 23:14
 * @Since: 1.0.0
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2){
            return s;
        }

        String result = s.substring(0, 1);
        int resultLength = 1;
        for (int i = 0; i < length - 1; i++){
            int ch = (int)s.charAt(i);
            if (length - i < resultLength) {
                break;
            }
            for (int j = length - 1; j > 0; j--){
                int index = s.lastIndexOf(ch, j);
                if (index == i){
                    break;
                }

                String sub = s.substring(i, index + 1);
                if (sub.length() <= resultLength){
                    break;
                }
                StringBuilder stringBuilder = new StringBuilder(sub);
                if (sub.equals(stringBuilder.reverse().toString())){
                    result = sub;
                    resultLength = sub.length();
                    break;
                }
            }

        }

        return result;
    }
}