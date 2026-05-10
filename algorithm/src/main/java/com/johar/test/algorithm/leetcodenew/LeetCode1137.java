package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/10 12:06]
 * @updateUser : [johar]
 * @updateTime : [2026/5/10 12:06]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1137 {

    /**
     * 泰波那契序列 Tn 定义如下：
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int res = 0;
        int t1 = 0, t2 = 1, t3 = 1;
        for (int i = 3; i <= n; i++) {
            res = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = res;
        }

        return res;
    }
}
