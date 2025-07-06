package com.johar.test.algorithm.nowcoder;

/**
 * @ClassName: MaxDiff
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/28 22:30
 * @Since: 1.0.0
 */
public class MaxDiff {

    /**
     * 有一个长为 n 的数组 A ，求满足 0 ≤ a ≤ b < n 的 A[b] - A[a] 的最大值。
     * 给定数组 A 及它的大小 n ，请返回最大差值。
     *
     * https://www.nowcoder.com/practice/a01abbdc52ba4d5f8777fb5dae91b204?tpId=128&tqId=33768&rp=1&ru=/exam/interview&qru=/exam/interview&sourceUrl=%2Fexam%2Finterview%3Fcompany%3D%5B%7B%2522companyId%2522%3A179%2C%2522companyName%2522%3A%2522%25E7%25BE%258E%25E5%259B%25A2%2522%7D%5D%26order%3D0&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * @param A
     * @param n
     * @return
     */
    public int getDis (int[] A, int n) {
        // write code here
        int max = 0;
        int min = A[0];
        for (int i = 1; i < n; i++){
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i] - min);
        }

        return max;
    }
}