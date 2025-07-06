package com.johar.test.algorithm.leetcode;

import java.util.Arrays;

/**
 * @ClassName: AssignCookies
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/30 22:44
 * @Since: 1.0.0
 */
public class AssignCookies {

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * https://leetcode.cn/problems/assign-cookies/description/
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0){
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ){
            if (g[i] <= s[j]){
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return result;
    }
}