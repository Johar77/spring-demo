package com.johar.test.algorithm.leetcodenew;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/5/28 10:57]
 * @updateUser : [johar]
 * @updateTime : [2026/5/28 10:57]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode76 {

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    /**
     * 76. 最小覆盖子串
     * https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-100-liked
     * 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
     *
     * 测试用例保证答案唯一。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int ansL = -1, ansR = -1, len = Integer.MAX_VALUE;
        while (r < sLen) {
            r++;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            char key = (char) entry.getKey();
            int value = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
