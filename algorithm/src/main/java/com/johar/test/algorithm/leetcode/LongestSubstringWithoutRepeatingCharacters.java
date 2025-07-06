package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: LongestSubstringWithoutRepeatingCharacters
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/26 23:35
 * @Since: 1.0.0
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int result = s.length() > 0 ? 1 : 0;
        int lastIndex = 0;
        int length = s.length();
        String temp = null;
        int ch;
        for (int i = 1; i < length; i++){
            temp = s.substring(lastIndex, i);
            ch = (int)s.charAt(i);
            if (temp.indexOf(ch) > -1){
                result = Math.max(result, i - lastIndex);
                lastIndex = lastIndex + temp.lastIndexOf(ch) + 1;
                if (result > length - 1 - lastIndex){
                    break;
                }
            } else {
                result = Math.max(result, i - lastIndex + 1);
            }
        }

        return result;
    }
}