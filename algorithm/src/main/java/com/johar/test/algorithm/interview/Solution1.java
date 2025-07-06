package com.johar.test.algorithm.interview;

import java.util.Objects;
import java.util.UUID;

/**
 * @ClassName: Solution1
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/4/8 11:43
 * @Since: 1.0.0
 */
public class Solution1 {

    /**
     * "aabcbccacbbcbaaba"
     * "cccccbba"
     * @param s
     * @return
     */
    public static String maxDictionaryOrder(String s) {
        // write code here
        if (Objects.isNull(s) || s.length() == 0){
            return null;
        }

        int length = s.length();
        char[] charArray = s.toCharArray();
        charArray[0] = s.charAt(length - 1);
        int j = 0;
        for (int i = length - 2; i >= 0; i--){
            if (s.charAt(i) >= charArray[j]){
                charArray[++j] = s.charAt(i);
            }
        }

        int resultLength = j + 1;
        for (int i = 0; i < j; i++, j--){
            char c = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = c;
        }

        return new String(charArray, 0, resultLength);
    }

    public static void main(String[] args) {
        System.out.println(maxDictionaryOrder("cmbchina"));
        System.out.println(maxDictionaryOrder("aabcbccacbbcbaaba"));
    }
}