package com.johar.test.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: WithoutRepeatingCharacters
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/7 17:01
 * @Since: 1.0.0
 */
public class WithoutRepeatingCharacters {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int right = 0;
        int length = s.length();
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if (i != 0){
                characterSet.remove(s.charAt(i - 1));
            }

            while (right < length && !characterSet.contains(s.charAt(right))){
                characterSet.add(s.charAt(right));
                right++;
            }
            result = Math.max(result, right - i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}