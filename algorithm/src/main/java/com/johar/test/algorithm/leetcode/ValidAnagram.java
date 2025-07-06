package com.johar.test.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ValidAnagram
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/9 16:30
 * @Since: 1.0.0
 */
public class ValidAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-anagram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return new String(s1).equals(new String(t1));
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            Integer num = map.getOrDefault(c, 0);
            map.put(c, num + 1);
        }
        for (int i = 0; i < len; i++){
            char c = t.charAt(i);
            Integer num = map.get(c);
            if (num == null){
                return false;
            }
            num--;
            if (num == 0){
                map.remove(c);
            } else {
                map.put(c, num);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(isAnagram("abcc", "ccba"));
//        System.out.println(isAnagram1("abcc", "ccba"));
        System.out.println(isAnagram1("a", "ab"));
    }
}